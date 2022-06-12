package dev.willcode.triviati.ui.about.modules.author.application

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.willcode.triviati.databinding.FragmentAuthorBinding
import dev.willcode.triviati.ui.about.modules.author.domain.Author
import dev.willcode.triviati.ui.about.modules.author.infraestructure.AuthorRepository

class AuthorAdapter : RecyclerView.Adapter<AuthorHolder>() {
    private val repository = AuthorRepository()
    private val dataSet: List<Author> = repository.getAuthors()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentAuthorBinding.inflate(inflater, parent, false)
        return AuthorHolder(binding)
    }

    override fun onBindViewHolder(holder: AuthorHolder, position: Int) = holder.bind(
        dataSet[position]
    )

    override fun getItemCount() = dataSet.size


}