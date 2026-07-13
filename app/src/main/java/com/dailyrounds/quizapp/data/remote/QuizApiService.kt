package com.dailyrounds.quizapp.data.remote

import com.dailyrounds.quizapp.data.model.Question
import com.dailyrounds.quizapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Url


interface QuizApiService {

    @GET
    suspend fun getQuestions(
        @Url url: String = Constants.QUESTIONS_JSON_URL
    ): List<Question>
}
