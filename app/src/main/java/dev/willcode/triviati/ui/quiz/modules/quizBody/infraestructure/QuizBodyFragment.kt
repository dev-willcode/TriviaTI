package dev.willcode.triviati.ui.quiz.modules.quizBody.infraestructure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.willcode.triviati.databinding.FragmentQuizBodyBinding
import dev.willcode.triviati.ui.quiz.domain.Quiz
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.application.AnswerQuizAdapter
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain.QuizAnswer

class QuizBodyFragment : Fragment() {
    private var _binding: FragmentQuizBodyBinding? = null
    private val binding get() = _binding!!
    private val adapter = AnswerQuizAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBodyBinding.inflate(inflater, container, false)
        val root: View = binding.root
        configFragmentView()
        return root
    }


    private fun configFragmentView() {
//        setupQuiz()
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupQuiz(quiz: Quiz) {
        binding.questionText.text = quiz.question
        adapter.setOptionQuizList(quiz.answers)
    }

    private fun setupAdapter() {
        adapter.setOnOptionQuizClickListener(object : AnswerQuizAdapter.OnOptionQuizClickListener {
            override fun onItemClick(dataSet: ArrayList<QuizAnswer>, position: Int) {
                println(dataSet[position].toString())
            }
        })
    }

    private fun setupRecyclerView() {
        val recycler = binding.answerRecycler
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }
}