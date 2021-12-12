package de.coldtea.anidex.base.data

import de.coldtea.anidex.base.data.api.JikanApi
import de.coldtea.anidex.base.data.db.AnidexDatabase
import javax.inject.Inject

class JikanRepository @Inject constructor(
    val jikanApi: JikanApi,
    val anidexDatabase: AnidexDatabase
){
    fun getAnimesByGenre(genreId: Int) =
        anidexDatabase.daoAnime.pagingSourceByGenre(genreId = genreId)
}