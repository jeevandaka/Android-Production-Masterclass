package com.dailyrounds.quizapp.domain.usecase

import com.dailyrounds.quizapp.data.model.Question
import com.dailyrounds.quizapp.data.repository.QuizRepository
import javax.inject.Inject


class GetQuestionsUseCase @Inject constructor(
    private val repository: QuizRepository
) {
    suspend operator fun invoke(): List<Question> = repository.getQuestions()
}
