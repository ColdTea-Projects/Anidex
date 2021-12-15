package de.coldtea.anidex.watchlist.domain.model

data class Watchlist(
    val animeId: Int,
    val name: String,
    val imageUrl: String,
    val score: Double
)
