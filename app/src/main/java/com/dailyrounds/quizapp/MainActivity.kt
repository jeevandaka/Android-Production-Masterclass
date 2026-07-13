package com.dailyrounds.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dailyrounds.quizapp.ui.navigation.QuizNavGraph
import com.dailyrounds.quizapp.ui.theme.QuizAppTheme
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseCrashlytics.getInstance().log("Quiz App Started")

        enableEdgeToEdge()
        setContent {
            QuizAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    QuizNavGraph()
                }
            }
        }
    }
}
