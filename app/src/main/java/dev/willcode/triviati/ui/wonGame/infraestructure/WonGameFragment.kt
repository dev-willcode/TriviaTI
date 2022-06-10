package dev.willcode.triviati.ui.wonGame.infraestructure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dev.willcode.triviati.databinding.FragmentWonGameBinding

class WonGameFragment : Fragment() {
    private lateinit var binding: FragmentWonGameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWonGameBinding.inflate(inflater, container, false)
        val root: View = binding.root
        configFragmentView(root)
        return root
    }

    private fun configFragmentView(root: View) {
        binding.confirmButton.setOnClickListener {
            tryAgain(root)
        }
    }

    private fun tryAgain(view: View) {
        val action = WonGameFragmentDirections.playAgain()
        view.findNavController().navigate(action)

    }
}