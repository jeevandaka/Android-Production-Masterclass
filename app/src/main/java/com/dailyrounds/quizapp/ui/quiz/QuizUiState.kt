package com.dailyrounds.quizapp.ui.quiz

import com.dailyrounds.quizapp.data.model.Question

/**
 * Per-question outcome, used to (a) drive the top progress dots and
 * (b) compute the results screen without re-deriving from raw indices.
 */
enum class QuestionOutcome { UNANSWERED, CORRECT, INCORRECT, SKIPPED }

/**
 * Single sealed state the QuizScreen renders from. Modeled as one state
 * machine (Loading -> Quiz -> Results, with Error as a side branch) rather
 * than scattered booleans, so the UI can never render an invalid combination
 * (e.g. "loading" and "showing question 7" at once).
 */
sealed interface QuizUiState {

    data object Loading : QuizUiState

    data class Error(val message: String) : QuizUiState

    data class Quiz(
        val questions: List<Question>,
        val currentIndex: Int,
        val selectedOptionIndex: Int?,
        val isAnswerRevealed: Boolean,
        val currentStreak: Int,
        val longestStreak: Int,
        val showStreakCelebration: Boolean,
        val outcomes: List<QuestionOutcome>
    ) : QuizUiState {
        val currentQuestion: Question get() = questions[currentIndex]
        val questionNumber: Int get() = currentIndex + 1
        val totalQuestions: Int get() = questions.size
        val isLastQuestion: Boolean get() = currentIndex == questions.lastIndex
    }

    data class Results(
        val total: Int,
        val correct: Int,
        val skipped: Int,
        val longestStreak: Int
    ) : QuizUiState
}
