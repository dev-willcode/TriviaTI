package dev.willcode.triviati.ui.wonGame.infraestructure

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dev.willcode.triviati.MainActivity
import dev.willcode.triviati.R
import dev.willcode.triviati.databinding.FragmentWonGameBinding

class WonGameFragment : Fragment() {
    private lateinit var binding: FragmentWonGameBinding
    private lateinit var mp: MediaPlayer

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
            mp.stop()
            (activity as MainActivity).mp.start()
            tryAgain(root)
        }
        setupBackListener(root)
        playSound()
    }

    private fun setupBackListener(root: View) {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            mp.stop()
            (activity as MainActivity).mp.start()
            goHome(root)
        }
    }

    private fun playSound() {
        (activity as MainActivity).mp.pause()
        mp = MediaPlayer.create(context, R.raw.winner)
        mp.start()
    }

    private fun goHome(view: View) {
        val action = WonGameFragmentDirections.goHome()
        view.findNavController().navigate(action)
    }

    private fun tryAgain(view: View) {
        val action = WonGameFragmentDirections.playAgain()
        view.findNavController().navigate(action)

    }
}