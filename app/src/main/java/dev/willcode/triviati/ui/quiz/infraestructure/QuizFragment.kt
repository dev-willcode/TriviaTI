package dev.willcode.triviati.ui.quiz.infraestructure


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.willcode.triviati.databinding.FragmentQuizBinding
import dev.willcode.triviati.ui.quiz.domain.Quiz
import java.util.*

class QuizFragment : Fragment() {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
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
    }

    private fun setupQuizzes() {
        currentQuizzes.addAll(repository.getRamdonQuizzes())
    }
}