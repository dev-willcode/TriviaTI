package dev.willcode.triviati.ui.about.modules.author.application

import androidx.recyclerview.widget.RecyclerView
import dev.willcode.triviati.databinding.FragmentAuthorBinding
import dev.willcode.triviati.ui.about.modules.author.domain.Author

class AuthorHolder(
    private val binding: FragmentAuthorBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Author) {
        binding.authorName.text = item.name
        binding.authorImage.setImageResource(item.image)
    }
}