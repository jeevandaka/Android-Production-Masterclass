package com.dailyrounds.quizapp.data.repository

import com.dailyrounds.quizapp.data.model.Question
import com.dailyrounds.quizapp.data.remote.LocalQuestionSource
import com.dailyrounds.quizapp.data.remote.QuizApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class QuizRepositoryImpl @Inject constructor(
    private val api: QuizApiService,
    private val localSource: LocalQuestionSource
) : QuizRepository {

    override suspend fun getQuestions(): List<Question> = withContext(Dispatchers.IO) {
        try {
            val remote = api.getQuestions()
            remote.ifEmpty { localSource.getQuestions() }
        } catch (e: IOException) {
            // No connectivity / timeout
            localSource.getQuestions()
        } catch (e: Exception) {
            // HTTP error, malformed JSON, placeholder URL not yet replaced, etc.
            localSource.getQuestions()
        }
    }
}
