package com.dailyrounds.quizapp.data.remote

import android.content.Context
import com.dailyrounds.quizapp.data.model.Question
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import javax.inject.Inject


class LocalQuestionSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val moshi: Moshi
) {
    fun getQuestions(): List<Question> {
        val json = context.assets.open("questions.json").bufferedReader().use(BufferedReader::readText)
        val listType = Types.newParameterizedType(List::class.java, Question::class.java)
        val adapter = moshi.adapter<List<Question>>(listType)
        return adapter.fromJson(json).orEmpty()
    }

    suspend fun getQuestionsAsync(): List<Question> = withContext(Dispatchers.IO) { getQuestions() }
}
