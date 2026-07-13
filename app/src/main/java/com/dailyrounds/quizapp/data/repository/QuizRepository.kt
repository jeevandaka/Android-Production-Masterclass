package com.dailyrounds.quizapp.data.repository

import com.dailyrounds.quizapp.data.model.Question

interface QuizRepository {
    suspend fun getQuestions(): List<Question>
}
