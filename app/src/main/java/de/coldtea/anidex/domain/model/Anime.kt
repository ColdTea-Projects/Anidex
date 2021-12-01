package de.coldtea.anidex.domain.model

data class Anime(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val rate: Double,
    val isBookmarked: Boolean,
    val genreId: Int
    )