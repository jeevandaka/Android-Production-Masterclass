package com.dailyrounds.quizapp.ui.quiz

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dailyrounds.quizapp.ui.components.OptionButton
import com.dailyrounds.quizapp.ui.components.OptionVisualState
import com.dailyrounds.quizapp.ui.components.ProgressDots
import com.dailyrounds.quizapp.ui.components.StreakCelebration
import com.dailyrounds.quizapp.ui.results.ResultsScreen
import com.dailyrounds.quizapp.ui.splash.SplashScreen
import kotlin.math.abs

private const val SWIPE_THRESHOLD_PX = 80f

@Composable
fun QuizRoute(
    viewModel: QuizViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    when (val s = state) {
        QuizUiState.Loading -> SplashScreen()
        is QuizUiState.Error -> ErrorContent(message = s.message, onRetry = viewModel::loadQuestions)
        is QuizUiState.Quiz -> QuizContent(
            state = s,
            onOptionSelected = viewModel::onOptionSelected,
            onSkip = viewModel::onSkipClicked,
            onSwipeNext = viewModel::onSwipeToNext,
            onStreakCelebrationShown = viewModel::onStreakCelebrationShown
        )
        is QuizUiState.Results -> ResultsScreen(
            correct = s.correct,
            total = s.total,
            skipped = s.skipped,
            longestStreak = s.longestStreak,
            onRestart = viewModel::restartQuiz
        )
    }
}

@Composable
private fun ErrorContent(message: String, onRetry: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Couldn't load the quiz", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Text(message, style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(16.dp))
        TextButton(onClick = onRetry) { Text("Retry") }
    }
}

@Composable
private fun QuizContent(
    state: QuizUiState.Quiz,
    onOptionSelected: (Int) -> Unit,
    onSkip: () -> Unit,
    onSwipeNext: () -> Unit,
    onStreakCelebrationShown: () -> Unit
) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            ProgressDots(outcomes = state.outcomes, currentIndex = state.currentIndex)
            Spacer(Modifier.height(12.dp))
            LinearProgressIndicator(
                progress = { state.questionNumber / state.totalQuestions.toFloat() },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Question ${state.questionNumber} of ${state.totalQuestions}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (state.showStreakCelebration) {
                StreakCelebration(
                    streak = state.currentStreak,
                    onFinished = onStreakCelebrationShown,
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                Spacer(Modifier.height(28.dp))
            }

            AnimatedContent(
                targetState = state.currentIndex,
                transitionSpec = {
                    (slideInHorizontally(tween(250)) { it } togetherWith
                        slideOutHorizontally(tween(250)) { -it })
                },
                label = "questionTransition",
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .pointerInput(state.currentIndex, state.isAnswerRevealed) {
                        var dragAmount = 0f
                        detectHorizontalDragGestures(
                            onDragStart = { dragAmount = 0f },
                            onHorizontalDrag = { _, delta -> dragAmount += delta },
                            onDragEnd = {
                                if (abs(dragAmount) > SWIPE_THRESHOLD_PX && !state.isAnswerRevealed) {
                                    onSwipeNext()
                                }
                            }
                        )
                    }
            ) { _ ->
                Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = state.currentQuestion.question,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(24.dp))
                    state.currentQuestion.options.forEachIndexed { index, option ->
                        val visualState = when {
                            !state.isAnswerRevealed -> OptionVisualState.DEFAULT
                            index == state.currentQuestion.correctAnswerIndex -> OptionVisualState.CORRECT
                            index == state.selectedOptionIndex -> OptionVisualState.INCORRECT_SELECTED
                            else -> OptionVisualState.DIMMED
                        }
                        OptionButton(
                            text = option,
                            state = visualState,
                            enabled = !state.isAnswerRevealed,
                            onClick = { onOptionSelected(index) },
                            modifier = Modifier.padding(vertical = 6.dp)
                        )
                    }
                }
            }

            if (!state.isAnswerRevealed) {
                TextButton(
                    onClick = onSkip,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Skip")
                }
            } else {
                Box(modifier = Modifier.height(48.dp))
            }
        }
    }
}
