package com.dailyrounds.quizapp.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dailyrounds.quizapp.ui.quiz.QuestionOutcome
import com.dailyrounds.quizapp.ui.theme.QuizCorrect
import com.dailyrounds.quizapp.ui.theme.QuizIncorrect
import com.dailyrounds.quizapp.ui.theme.QuizSurfaceVariant

@Composable
fun ProgressDots(
    outcomes: List<QuestionOutcome>,
    currentIndex: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        outcomes.forEachIndexed { index, outcome ->
            val isCurrent = index == currentIndex
            val color by animateColorAsState(
                targetValue = when (outcome) {
                    QuestionOutcome.CORRECT -> QuizCorrect
                    QuestionOutcome.INCORRECT -> QuizIncorrect
                    QuestionOutcome.SKIPPED -> QuizSurfaceVariant
                    QuestionOutcome.UNANSWERED ->
                        if (isCurrent) MaterialTheme.colorScheme.primary else QuizSurfaceVariant
                },
                label = "dotColor"
            )
            Box(
                modifier = Modifier
                    .size(if (isCurrent) 12.dp else 9.dp)
                    .clip(CircleShape)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                when (outcome) {
                    QuestionOutcome.CORRECT -> Icon(Icons.Filled.Check, null, tint = Color.White, modifier = Modifier.size(7.dp))
                    QuestionOutcome.INCORRECT -> Icon(Icons.Filled.Close, null, tint = Color.White, modifier = Modifier.size(7.dp))
                    else -> {}
                }
            }
        }
    }
}
