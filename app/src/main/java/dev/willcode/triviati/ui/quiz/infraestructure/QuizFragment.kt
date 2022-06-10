package dev.willcode.triviati.ui.quiz.infraestructure


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.willcode.triviati.databinding.FragmentQuizBinding
import dev.willcode.triviati.ui.quiz.application.QuizViewModel
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.application.AnswerQuizAdapter
import dev.willcode.triviati.ui.quiz.modules.optionQuiz.domain.QuizAnswer

class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    private val repository = QuizRepository()
    private val viewModel: QuizViewModel by viewModels()
    private val adapter = AnswerQuizAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        val root: View = binding.root
        configFragmentView(root)
        return root
    }

    private fun configFragmentView(root: View) {
        setupQuiz()
        setupAdapter()
        setupRecyclerAnswer()
        binding.confirmButton.setOnClickListener {
            val answer = adapter.getSelectedAnswer()
            if (answer === null) {
                Toast.makeText(
                    context,
                    "Primero selecciona una respuesta!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                if (answer.correct) {
                    continueGame(root)
                } else {
                    lostGame(root)
                }
            }
        }
        // set first quiz question
        viewModel.selectNextQuiz()
    }

    private fun lostGame(root: View) {
        val action = QuizFragmentDirections.goLostGame(viewModel.getCorrectQuestions())
        root.findNavController().navigate(action)
    }

    private fun wonGame(root: View) {
        val action = QuizFragmentDirections.goWonGame()
        root.findNavController().navigate(action)
    }

    private fun continueGame(root: View) {
        if (viewModel.existNextQuiz()) viewModel.selectNextQuiz()
        else wonGame(root)
    }

    private fun setupQuiz() {
        viewModel.setQuizzes(repository.getRandomQuizzes())
        bindQuizData()
    }

    private fun bindQuizData() {
        viewModel.currentQuiz.observe(viewLifecycleOwner) {
            binding.questionText.text = it.question
            adapter.setOptionQuizList(it.answers)
        }
    }

    private fun setupAdapter() {
        adapter.setOnOptionQuizClickListener(object : AnswerQuizAdapter.OnOptionQuizClickListener {
            override fun onItemClick(item: QuizAnswer, position: Int) {
                adapter.uncheckPreviousSelectedAnswer()
                adapter.checkAnswer(item)
            }
        })
    }

    private fun setupRecyclerAnswer() {
        val recycler = binding.answerRecycler
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = adapter
    }
}