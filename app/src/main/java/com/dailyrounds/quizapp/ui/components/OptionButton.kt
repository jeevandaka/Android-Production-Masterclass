package com.dailyrounds.quizapp.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dailyrounds.quizapp.ui.theme.QuizCorrect
import com.dailyrounds.quizapp.ui.theme.QuizIncorrect
import com.dailyrounds.quizapp.ui.theme.QuizSurfaceVariant

enum class OptionVisualState { DEFAULT, CORRECT, INCORRECT_SELECTED, DIMMED }

@Composable
fun OptionButton(
    text: String,
    state: OptionVisualState,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor by animateColorAsState(
        targetValue = when (state) {
            OptionVisualState.DEFAULT -> QuizSurfaceVariant
            OptionVisualState.CORRECT -> QuizCorrect
            OptionVisualState.INCORRECT_SELECTED -> QuizIncorrect
            OptionVisualState.DIMMED -> QuizSurfaceVariant.copy(alpha = 0.5f)
        },
        label = "optionBackground"
    )

    val contentDescriptionSuffix = when (state) {
        OptionVisualState.CORRECT -> ", correct answer"
        OptionVisualState.INCORRECT_SELECTED -> ", your answer, incorrect"
        else -> ""
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(backgroundColor)
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.15f), RoundedCornerShape(14.dp))
            .clickable(enabled = enabled, onClick = onClick)
            .padding(PaddingValues(horizontal = 20.dp, vertical = 18.dp))
            .semantics { contentDescription = text + contentDescriptionSuffix },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f)
        )
        when (state) {
            OptionVisualState.CORRECT -> Icon(Icons.Filled.Check, contentDescription = null, tint = MaterialTheme.colorScheme.onSurface)
            OptionVisualState.INCORRECT_SELECTED -> Icon(Icons.Filled.Close, contentDescription = null, tint = MaterialTheme.colorScheme.onSurface)
            else -> {}
        }
    }
}
