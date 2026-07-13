package com.dailyrounds.quizapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = QuizPrimary,
    onPrimary = QuizOnPrimary,
    background = QuizBackground,
    surface = QuizSurface,
    surfaceVariant = QuizSurfaceVariant,
    error = QuizIncorrect,
    onBackground = QuizTextPrimary,
    onSurface = QuizTextPrimary
)

private val LightColors = lightColorScheme(
    primary = QuizPrimary,
    onPrimary = QuizOnPrimary,
    error = QuizIncorrect
)

/**
 * The design reference is dark-themed, but we still respect system light/dark
 * mode (JD explicitly calls out "dealt with both light/dark modes") rather
 * than hard-locking the app to dark.
 */
@Composable
fun QuizAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colorScheme,
        typography = QuizTypography,
        content = content
    )
}
