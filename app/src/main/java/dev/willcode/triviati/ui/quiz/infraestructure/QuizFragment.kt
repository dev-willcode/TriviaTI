package dev.willcode.triviati.ui.quiz.infraestructure


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.willcode.triviati.databinding.FragmentQuizBinding
import dev.willcode.triviati.ui.quiz.domain.Quiz
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.application.AnswerQuizAdapter
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain.QuizAnswer
import java.util.*

class QuizFragment : Fragment() {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private val adapter = AnswerQuizAdapter()
    private val repository = QuizRepository()
    private val currentQuizzes = LinkedList<Quiz>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        val root: View = binding.root
        configFragmentView()
        return root
    }


    private fun configFragmentView() {
        setupQuizzes()
        setupAdapter()
        setupRecyclerView()
    }

    private fun setupQuizzes() {
        currentQuizzes.addAll(repository.getRamdonQuizzes())
        setupCurrentQuiz()
    }

    private fun setupCurrentQuiz() {
        setupQuiz(currentQuizzes.first)
        currentQuizzes.removeFirst()
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