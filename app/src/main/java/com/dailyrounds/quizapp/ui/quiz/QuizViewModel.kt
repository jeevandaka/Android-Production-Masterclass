package com.dailyrounds.quizapp.ui.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dailyrounds.quizapp.domain.usecase.GetQuestionsUseCase
import com.dailyrounds.quizapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getQuestionsUseCase: GetQuestionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<QuizUiState>(QuizUiState.Loading)
    val uiState: StateFlow<QuizUiState> = _uiState.asStateFlow()

    private var autoAdvanceJob: Job? = null

    init {
        loadQuestions()
    }

    fun loadQuestions() {
        autoAdvanceJob?.cancel()
        _uiState.value = QuizUiState.Loading
        viewModelScope.launch {
            try {
                val questions = getQuestionsUseCase()
                if (questions.isEmpty()) {
                    _uiState.value = QuizUiState.Error("No questions available.")
                    return@launch
                }
                _uiState.value = QuizUiState.Quiz(
                    questions = questions,
                    currentIndex = 0,
                    selectedOptionIndex = null,
                    isAnswerRevealed = false,
                    currentStreak = 0,
                    longestStreak = 0,
                    showStreakCelebration = false,
                    outcomes = List(questions.size) { QuestionOutcome.UNANSWERED }
                )
            } catch (e: Exception) {
                _uiState.value = QuizUiState.Error(e.message ?: "Something went wrong.")
            }
        }
    }

    /** User tapped one of the four options. */
    fun onOptionSelected(optionIndex: Int) {
        val current = _uiState.value as? QuizUiState.Quiz ?: return
        if (current.isAnswerRevealed) return

        val isCorrect = optionIndex == current.currentQuestion.correctAnswerIndex
        val newStreak = if (isCorrect) current.currentStreak + 1 else 0
        val newLongest = maxOf(current.longestStreak, newStreak)
        val hitStreakMilestone = isCorrect && newStreak > 0 && newStreak % Constants.STREAK_THRESHOLD == 0

        val newOutcomes = current.outcomes.toMutableList().apply {
            this[current.currentIndex] =
                if (isCorrect) QuestionOutcome.CORRECT else QuestionOutcome.INCORRECT
        }

        _uiState.value = current.copy(
            selectedOptionIndex = optionIndex,
            isAnswerRevealed = true,
            currentStreak = newStreak,
            longestStreak = newLongest,
            showStreakCelebration = hitStreakMilestone,
            outcomes = newOutcomes
        )

        scheduleAutoAdvance()
    }

    /** "Skip" button. */
    fun onSkipClicked() {
        val current = _uiState.value as? QuizUiState.Quiz ?: return
        if (current.isAnswerRevealed) return

        autoAdvanceJob?.cancel()

        val newOutcomes = current.outcomes.toMutableList().apply {
            this[current.currentIndex] = QuestionOutcome.SKIPPED
        }
        goToNextOrFinish(current.copy(currentStreak = 0, outcomes = newOutcomes))
    }

    /** Called by the UI once the streak-celebration animation has played out. */
    fun onStreakCelebrationShown() {
        val current = _uiState.value as? QuizUiState.Quiz ?: return
        _uiState.value = current.copy(showStreakCelebration = false)
    }

    /** Swipe-left gesture on the question card behaves exactly like Skip. */
    fun onSwipeToNext() = onSkipClicked()

    fun restartQuiz() {
        loadQuestions()
    }

    private fun scheduleAutoAdvance() {
        autoAdvanceJob?.cancel()
        autoAdvanceJob = viewModelScope.launch {
            delay(Constants.ANSWER_REVEAL_DELAY_MS)
            val current = _uiState.value as? QuizUiState.Quiz ?: return@launch
            goToNextOrFinish(current)
        }
    }

    private fun goToNextOrFinish(state: QuizUiState.Quiz) {
        if (state.isLastQuestion) {
            _uiState.value = buildResults(state)
        } else {
            _uiState.value = state.copy(
                currentIndex = state.currentIndex + 1,
                selectedOptionIndex = null,
                isAnswerRevealed = false,
                showStreakCelebration = false
            )
        }
    }

    private fun buildResults(state: QuizUiState.Quiz): QuizUiState.Results {
        val correct = state.outcomes.count { it == QuestionOutcome.CORRECT }
        val skipped = state.outcomes.count { it == QuestionOutcome.SKIPPED }
        return QuizUiState.Results(
            total = state.questions.size,
            correct = correct,
            skipped = skipped,
            longestStreak = state.longestStreak
        )
    }

    override fun onCleared() {
        super.onCleared()
        autoAdvanceJob?.cancel()
    }
}
