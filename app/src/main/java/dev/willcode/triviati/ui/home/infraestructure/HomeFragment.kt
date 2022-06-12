package dev.willcode.triviati.ui.home.infraestructure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.gms.ads.AdRequest
import dev.willcode.triviati.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit  var binding: FragmentHomeBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        configFragmentView(root)
        return root
    }

    private fun configFragmentView(root: View) {
        setupAds()
        binding.buttonPlay.setOnClickListener {
            val action = HomeFragmentDirections.openQuiz()
            root.findNavController().navigate(action)
        }
        binding.buttonAbout.setOnClickListener {
            val action = HomeFragmentDirections.openAbout()
            root.findNavController().navigate(action)
        }
    }

    private fun setupAds() {
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }
}