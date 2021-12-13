package de.coldtea.anidex.content.domain

import de.coldtea.anidex.base.data.api.JikanApi
import de.coldtea.anidex.base.data.db.AnidexDatabase
import javax.inject.Inject

class ContentRepository @Inject constructor(
    val jikanApi: JikanApi,
    val anidexDatabase: AnidexDatabase
){
    fun getAnimesByGenre(genreId: Int) =
        anidexDatabase.daoAnime.pagingSourceByGenre(genreId = genreId)

    suspend fun isBookmarked(animeId: Int) =
        anidexDatabase.daoWatchlist.getWatchlistById(animeId).isNotEmpty()

}