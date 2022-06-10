package dev.willcode.triviati.ui.quiz.modules.optionQuiz.application


import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import dev.willcode.triviati.R
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
        binding.answerText.text = item.question
        if (item.checked) {
            binding.answerIcon.setImageDrawable(
                ResourcesCompat.getDrawable(
                    itemView.resources,
                    R.drawable.checked,
                    null
                )
            )
            binding.answerText.setTextColor(
                ResourcesCompat.getColor(
                    itemView.resources, R.color.purple_500, null
                )
            )
            binding.answerContainer.background = ResourcesCompat.getDrawable(
                itemView.resources,
                R.drawable.rounded_corners_button,
                null
            );
        } else {
            binding.answerIcon.setImageDrawable(
                ResourcesCompat.getDrawable(
                    itemView.resources,
                    R.drawable.unchecked,
                    null
                )
            )
            binding.answerText.setTextColor(
                ResourcesCompat.getColor(
                    itemView.resources, R.color.white, null
                )
            )
            binding.answerContainer.background = ResourcesCompat.getDrawable(
                itemView.resources,
                R.drawable.rounded_corners_button_stroke,
                null
            );
        }
    }

    private fun configureSelectListener(listener: AnswerQuizAdapter.OnOptionQuizClickListener) {
        binding.answerContainer.setOnClickListener {
            listener.onItemClick(dataSet[absoluteAdapterPosition], absoluteAdapterPosition)
        }
    }
}