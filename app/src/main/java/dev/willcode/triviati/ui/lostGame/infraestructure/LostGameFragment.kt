package dev.willcode.triviati.ui.lostGame.infraestructure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import dev.willcode.triviati.databinding.FragmentLostGameBinding

class LostGameFragment : Fragment() {
    val args: LostGameFragmentArgs by navArgs()
    private lateinit var binding: FragmentLostGameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLostGameBinding.inflate(inflater, container, false)
        val root: View = binding.root
        configFragmentView(root)
        return root
    }

    private fun configFragmentView(root: View) {
        binding.correctQuestions.text = args.correctQuestions.toString()
        binding.confirmButton.setOnClickListener {
            tryAgain(root)
        }
    }

    private fun tryAgain(view: View) {
        val action = LostGameFragmentDirections.playAgain()
        view.findNavController().navigate(action)
    }
}