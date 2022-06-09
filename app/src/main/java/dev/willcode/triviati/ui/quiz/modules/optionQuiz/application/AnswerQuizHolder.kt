package dev.willcode.triviati.ui.quiz.modules.optionQuiz.application

import androidx.recyclerview.widget.RecyclerView
import dev.willcode.triviati.databinding.FragmentAnswerQuizBinding
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain.QuizAnswer

class AnswerQuizHolder(
    private val binding: FragmentAnswerQuizBinding,
    private val dataSet: ArrayList<QuizAnswer>,
    listener: AnswerQuizAdapter.OnOptionQuizClickListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        configureSelectListener(listener)
    }

    fun bind(item: QuizAnswer) {
        binding.answerId.text = item.index.toString()
        binding.answerText.text = item.question
    }

    private fun configureSelectListener(listener: AnswerQuizAdapter.OnOptionQuizClickListener) {
        binding.answerContainer.setOnClickListener {
            listener.onItemClick(dataSet, absoluteAdapterPosition)
        }
    }
}