package dev.willcode.triviati.ui.lostGame.infraestructure

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import dev.willcode.triviati.MainActivity
import dev.willcode.triviati.R
import dev.willcode.triviati.databinding.FragmentLostGameBinding
import dev.willcode.triviati.ui.wonGame.infraestructure.WonGameFragmentDirections

class LostGameFragment : Fragment() {
    private lateinit var binding: FragmentLostGameBinding
    val args: LostGameFragmentArgs by navArgs()
    private lateinit var mp: MediaPlayer

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
        mp = MediaPlayer.create(context, R.raw.looser)
        mp.start()
    }

    private fun goHome(view: View) {
        val action = WonGameFragmentDirections.goHome()
        view.findNavController().navigate(action)
    }

    private fun tryAgain(view: View) {
        val action = LostGameFragmentDirections.playAgain()
        view.findNavController().navigate(action)
    }
}