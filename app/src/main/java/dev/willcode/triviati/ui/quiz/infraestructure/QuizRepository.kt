package dev.willcode.triviati.ui.quiz.infraestructure

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.willcode.triviati.ui.quiz.domain.Quiz
import java.io.IOException
import kotlin.random.Random
import kotlin.random.nextInt


class QuizRepository {
    fun getRandomQuizzes(context: Context?): List<Quiz> {
        val quizList: List<Quiz> = getQuizzesList(context)
        val randomInts = generateSequence { Random.nextInt(quizList.indices) }
            .distinct()
            .take(2)
            .toList()
        val randomList = randomInts.map { index -> quizList[index] }
        return ArrayList(randomList.map { it.copy() })
    }

    private fun getQuizzesList(context: Context?): List<Quiz> {
        if (context == null) return listOf()
        return Gson().fromJson(getQuizzesFile(context), object : TypeToken<List<Quiz>>() {}.type)
    }

    private fun getQuizzesFile(context: Context): String? {
        val fileName = "quizzes.json"
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}