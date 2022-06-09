package dev.willcode.triviati.ui.quiz.modules.optionQuiz.application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain.QuizAnswer
import dev.willcode.triviati.databinding.FragmentAnswerQuizBinding

class AnswerQuizAdapter : RecyclerView.Adapter<AnswerQuizHolder>() {
    private val dataSet: ArrayList<QuizAnswer> = ArrayList()
    private lateinit var clickListener: OnOptionQuizClickListener

    interface OnOptionQuizClickListener {
        fun onItemClick(dataSet: ArrayList<QuizAnswer>, position: Int)
    }

    fun setOptionQuizList(dataSet: List<QuizAnswer>) {
        this.dataSet.addAll(dataSet)
        notifyItemRangeInserted(this.dataSet.size, this.dataSet.size + dataSet.size - 1)
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
}