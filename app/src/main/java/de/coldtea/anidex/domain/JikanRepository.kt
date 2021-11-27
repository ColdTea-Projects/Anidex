package de.coldtea.anidex.domain

import de.coldtea.anidex.data.JikanApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class JikanRepository @Inject constructor(
    private val jikanApi: JikanApi
) {
    suspend fun getAnimeByGenre(id: Int, pageNumber: Int) = withContext(Dispatchers.IO) {
        jikanApi.getAnimeByGenre(id, pageNumber)
    }
}