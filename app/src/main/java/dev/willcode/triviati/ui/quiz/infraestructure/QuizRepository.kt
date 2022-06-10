package dev.willcode.triviati.ui.quiz.infraestructure

import dev.willcode.triviati.ui.quiz.domain.Quiz
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain.QuizAnswer
import kotlin.random.Random
import kotlin.random.nextInt

class QuizRepository {
    private val list = listOf(
        Quiz(
            1,
            "hola!",
            listOf(QuizAnswer(1, "hola 1", false, false), QuizAnswer(1, "hola 2", false, true))
        ),
        Quiz(
            2,
            "adios!",
            listOf(QuizAnswer(1, "adios 1", false, true), QuizAnswer(1, "adios 2", false, false))
        ),
    )

    fun getRandomQuizzes(): List<Quiz> {
        val randomInts = generateSequence { Random.nextInt(list.indices) }
            .distinct()
            .take(2)
            .toList()
        val randomList = randomInts.map { index -> list[index] }
        return ArrayList(randomList.map { it.copy() })
    }
}