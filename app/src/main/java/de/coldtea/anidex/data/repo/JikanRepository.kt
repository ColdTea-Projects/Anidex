package de.coldtea.anidex.data.repo

import de.coldtea.anidex.data.api.JikanApi
import de.coldtea.anidex.data.db.AnidexDatabase
import javax.inject.Inject

class JikanRepository @Inject constructor(
    val jikanApi: JikanApi,
    val anidexDatabase: AnidexDatabase
){
    fun getAnimesByGenre(genreId: Int) =
        anidexDatabase.daoAnime.pagingSourceByGenre(genreId = genreId)
}