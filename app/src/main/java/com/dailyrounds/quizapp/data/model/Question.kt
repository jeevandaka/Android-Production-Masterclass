package com.dailyrounds.quizapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Question(
    @Json(name = "id") val id: Int,
    @Json(name = "question") val question: String,
    @Json(name = "options") val options: List<String>,
    @Json(name = "correctOptionIndex") val correctAnswerIndex: Int
)
