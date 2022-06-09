package dev.willcode.triviati.ui.quiz.domain

import dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain.QuizAnswer

data class Quiz(
    val id: Int,
    val question: String,
    val answers: List<QuizAnswer>
)