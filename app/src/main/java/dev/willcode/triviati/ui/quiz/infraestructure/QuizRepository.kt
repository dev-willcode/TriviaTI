package dev.willcode.triviati.ui.quiz.infraestructure

import dev.willcode.triviati.ui.quiz.domain.Quiz
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain.QuizAnswer
import kotlin.random.Random

class QuizRepository {
    val Quizzes = listOf(
        Quiz(1, "hola!", listOf(QuizAnswer(1, "hola mundo")))
    )

    fun getRamdonQuizzes(): List<Quiz> {
        val randomValues =List(5) {
            Random.nextInt(0, Quizzes.size)
        }
        val selectedQuizzes = ArrayList<Quiz>()
        for (index in randomValues) {
            selectedQuizzes.add(Quizzes[index])
        }
        return selectedQuizzes
    }
}