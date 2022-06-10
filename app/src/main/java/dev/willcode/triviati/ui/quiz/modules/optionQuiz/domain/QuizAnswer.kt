package dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain

data class QuizAnswer(
    val id: Int,
    val question: String,
    var checked: Boolean,
    var correct: Boolean,
)