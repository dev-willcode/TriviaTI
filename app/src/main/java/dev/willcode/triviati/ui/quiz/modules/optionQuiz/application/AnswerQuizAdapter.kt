package dev.willcode.triviati.ui.quiz.modules.optionQuiz.application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain.QuizAnswer
import dev.willcode.triviati.databinding.FragmentAnswerQuizBinding

class AnswerQuizAdapter : RecyclerView.Adapter<AnswerQuizHolder>() {
    private val dataSet: ArrayList<QuizAnswer> = ArrayList()
    private lateinit var clickListener: OnOptionQuizClickListener
    private var selectedAnswer: QuizAnswer? = null

    interface OnOptionQuizClickListener {
        fun onItemClick(item: QuizAnswer, position: Int)
    }

    fun setOptionQuizList(quizzes: List<QuizAnswer>) {
        val previousDataSetSize = dataSet.size
        dataSet.clear()
        notifyItemRangeRemoved(0, previousDataSetSize)
        dataSet.addAll(quizzes)
        notifyItemRangeInserted(0, quizzes.size)

    }

    fun setOnOptionQuizClickListener(listener: OnOptionQuizClickListener) {
        clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerQuizHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentAnswerQuizBinding.inflate(inflater, parent, false)
        return AnswerQuizHolder(binding, dataSet, clickListener)
    }

    override fun onBindViewHolder(holder: AnswerQuizHolder, position: Int) = holder.bind(
        dataSet[position]
    )

    override fun getItemCount() = dataSet.size

    fun checkAnswer(answer: QuizAnswer) {
        selectedAnswer = answer
        if (!answer.checked) {
            answer.checked = true
            notifyItemChanged(dataSet.indexOf(answer))
        }
    }

    fun uncheckPreviousSelectedAnswer() {
        if (selectedAnswer !== null) {
            selectedAnswer?.checked = false
            notifyItemChanged(dataSet.indexOf(selectedAnswer))
        }
    }

    fun getSelectedAnswer():QuizAnswer? {
        return selectedAnswer
    }
}