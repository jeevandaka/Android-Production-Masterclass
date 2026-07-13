package com.dailyrounds.quizapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dailyrounds.quizapp.ui.quiz.QuizRoute

object Routes {
    const val QUIZ = "quiz"
}

@Composable
fun QuizNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.QUIZ) {
        composable(Routes.QUIZ) {
            QuizRoute()
        }
    }
}
