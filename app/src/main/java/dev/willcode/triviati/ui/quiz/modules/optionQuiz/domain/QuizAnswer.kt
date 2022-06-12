package dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain

data class QuizAnswer(
    val id: Int,
    val question: String,
    var correct: Boolean,
    var checked: Boolean = false,
)