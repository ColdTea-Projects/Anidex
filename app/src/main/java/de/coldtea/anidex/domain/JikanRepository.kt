package de.coldtea.anidex.domain

import de.coldtea.anidex.data.JikanApi
import javax.inject.Inject

class JikanRepository @Inject constructor(
    private val jikanApi: JikanApi
){
    suspend fun getAnimeByGenre(id: Int, name: String, pageNumber: Int) = jikanApi.getAnimeByGenre(id, pageNumber)
}