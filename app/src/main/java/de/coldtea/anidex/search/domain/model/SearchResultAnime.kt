package de.coldtea.anidex.search.domain.model

data class SearchResultAnime(
    val animeId: Int,
    val imageUrl: String,
    val title: String,
    val synopsis: String
)
