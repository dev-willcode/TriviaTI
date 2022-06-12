package dev.willcode.triviati.ui.about.infraestructure

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.willcode.triviati.databinding.FragmentAboutBinding
import dev.willcode.triviati.ui.about.modules.author.application.AuthorAdapter

class AboutFragment : Fragment() {
    private lateinit var binding: FragmentAboutBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root
        configFragmentView()
        return root
    }

    private fun configFragmentView() {
        setupRecycler()
    }

    private fun setupRecycler() {
        val recycler  = binding.authorRecycler
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycler.adapter = AuthorAdapter()
    }
}