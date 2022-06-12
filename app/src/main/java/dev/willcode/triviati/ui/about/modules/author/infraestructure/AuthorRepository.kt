package dev.willcode.triviati.ui.about.modules.author.infraestructure

import dev.willcode.triviati.R
import dev.willcode.triviati.ui.about.modules.author.domain.Author

class AuthorRepository {
    private val authorList = listOf(
        Author("Bryan Camacho", R.drawable.bryan),
        Author("Willy Carreño", R.drawable.willy),
        Author("Jorge Jarrin", R.drawable.jorge),
        Author("Arely Martinez", R.drawable.arely),
        Author("David Millán", R.drawable.david),
    )

    fun getAuthors(): List<Author> {
        return authorList.map { it.copy() }
    }
}