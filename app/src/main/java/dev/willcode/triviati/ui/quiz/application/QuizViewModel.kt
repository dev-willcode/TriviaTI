package dev.willcode.triviati.ui.quiz.application

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.willcode.triviati.ui.quiz.domain.Quiz

class QuizViewModel : ViewModel() {
    private val quizzes: MutableList<Quiz> = mutableListOf()

    private var quizIndex = 0
    private val mutableSelectedItem = MutableLiveData<Quiz>()
    val currentQuiz: LiveData<Quiz> get() = mutableSelectedItem

    private fun selectItem(item: Quiz) {
        mutableSelectedItem.value = item
    }

    fun setQuizzes(list: List<Quiz>) {
        quizzes.addAll(list)
    }

    fun existNextQuiz(): Boolean {
        return ((quizIndex) < quizzes.size)
    }

    fun selectNextQuiz() {
        val index = quizIndex++
        if (index >= quizzes.size) {
            throw Exception("No more quizzes.")
        }
        selectItem(quizzes[index])
    }
}