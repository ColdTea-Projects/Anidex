package de.coldtea.anidex.content.domain.model

import de.coldtea.anidex.content.data.api.model.animesbygenre.AnimeDetailResponse

data class AnimeByGenreBundle(val id: Int, val name: String, val animes: List<AnimeDetailResponse>)