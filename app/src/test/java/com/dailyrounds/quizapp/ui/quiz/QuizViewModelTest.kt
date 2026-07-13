package com.dailyrounds.quizapp.ui.quiz

import com.dailyrounds.quizapp.data.model.Question
import com.dailyrounds.quizapp.data.repository.QuizRepository
import com.dailyrounds.quizapp.domain.usecase.GetQuestionsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * A fake repository instead of a mocking framework -- there's exactly one
 * method to fake, so this is both simpler and faster than pulling in Mockito/
 * MockK for a single-method interface.
 */
private class FakeQuizRepository(private val questions: List<Question>) : QuizRepository {
    override suspend fun getQuestions(): List<Question> = questions
}

private fun sampleQuestions(count: Int = 5) = (0 until count).map { i ->
    Question(
        id = i,
        question = "Q$i",
        options = listOf("A", "B", "C", "D"),
        correctAnswerIndex = 0 // "A" is always correct in these fixtures
    )
}

@OptIn(ExperimentalCoroutinesApi::class)
class QuizViewModelTest {

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private fun buildViewModel(questions: List<Question> = sampleQuestions()): QuizViewModel {
        val repo = FakeQuizRepository(questions)
        return QuizViewModel(GetQuestionsUseCase(repo))
    }

    @Test
    fun `loads questions into Quiz state`() = runTest {
        val vm = buildViewModel()
        dispatcher.scheduler.advanceUntilIdle()

        val state = vm.uiState.value
        assertTrue(state is QuizUiState.Quiz)
        assertEquals(5, (state as QuizUiState.Quiz).totalQuestions)
    }

    @Test
    fun `correct answer increments streak, wrong answer resets it`() = runTest {
        val vm = buildViewModel()
        dispatcher.scheduler.advanceUntilIdle()

        // Q0: correct (index 0)
        vm.onOptionSelected(0)
        var state = vm.uiState.value as QuizUiState.Quiz
        assertEquals(1, state.currentStreak)

        dispatcher.scheduler.advanceUntilIdle() // let the 2s auto-advance fire
        // Q1: wrong (index 1)
        vm.onOptionSelected(1)
        state = vm.uiState.value as QuizUiState.Quiz
        assertEquals(0, state.currentStreak)
    }

    @Test
    fun `streak celebration triggers exactly at the threshold`() = runTest {
        val vm = buildViewModel(sampleQuestions(10))
        dispatcher.scheduler.advanceUntilIdle()

        repeat(2) {
            vm.onOptionSelected(0) // correct
            val midState = vm.uiState.value as QuizUiState.Quiz
            assertEquals(false, midState.showStreakCelebration)
            dispatcher.scheduler.advanceUntilIdle()
        }
        vm.onOptionSelected(0) // 3rd correct in a row
        val state = vm.uiState.value as QuizUiState.Quiz
        assertEquals(3, state.currentStreak)
        assertTrue(state.showStreakCelebration)
    }

    @Test
    fun `skip advances immediately without waiting for the reveal delay`() = runTest {
        val vm = buildViewModel()
        dispatcher.scheduler.advanceUntilIdle()

        vm.onSkipClicked()
        // No advanceUntilIdle() needed -- skip must not depend on the 2s timer.
        val state = vm.uiState.value as QuizUiState.Quiz
        assertEquals(1, state.currentIndex)
        assertEquals(QuestionOutcome.SKIPPED, state.outcomes[0])
    }

    @Test
    fun `finishing the last question produces a Results state`() = runTest {
        val vm = buildViewModel(sampleQuestions(1))
        dispatcher.scheduler.advanceUntilIdle()

        vm.onOptionSelected(0)
        dispatcher.scheduler.advanceUntilIdle()

        val state = vm.uiState.value
        assertTrue(state is QuizUiState.Results)
        assertEquals(1, (state as QuizUiState.Results).correct)
    }

    @Test
    fun `restart resets back to question one with a clean slate`() = runTest {
        val vm = buildViewModel(sampleQuestions(1))
        dispatcher.scheduler.advanceUntilIdle()
        vm.onOptionSelected(0)
        dispatcher.scheduler.advanceUntilIdle()

        vm.restartQuiz()
        dispatcher.scheduler.advanceUntilIdle()

        val state = vm.uiState.value as QuizUiState.Quiz
        assertEquals(0, state.currentIndex)
        assertEquals(0, state.currentStreak)
        assertTrue(state.outcomes.all { it == QuestionOutcome.UNANSWERED })
    }
}
