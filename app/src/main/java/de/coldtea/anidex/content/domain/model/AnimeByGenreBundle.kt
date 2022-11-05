package de.coldtea.anidex.content.domain.model

import de.coldtea.anidex.content.data.api.model.animesbygenre.DataResponse

data class AnimeByGenreBundle(val id: Int, val name: String, val animes: List<DataResponse>)