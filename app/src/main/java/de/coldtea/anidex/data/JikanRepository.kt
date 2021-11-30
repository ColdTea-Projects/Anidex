package de.coldtea.anidex.data

import de.coldtea.anidex.data.api.JikanApi
import de.coldtea.anidex.data.db.AnidexDatabase
import de.coldtea.anidex.data.db.dao.DaoAnime
import de.coldtea.anidex.domain.extensions.convertToDomain
import de.coldtea.anidex.domain.model.Anime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class JikanRepository @Inject constructor(
    private val jikanApi: JikanApi,
    private val anidexDatabase: AnidexDatabase
) {
    val daoAnime: DaoAnime by lazy { anidexDatabase.daoAnime }

    //
    @Throws(HttpException::class)
    suspend fun getAnimeByGenre(id: Int, pageNumber: Int):List<Anime>? = withContext(Dispatchers.IO) {
        val onlineAnime = try {
            getAnimeByGenreApi(id, pageNumber)
        }catch (exception: HttpException){
            throw exception
        }

        if (onlineAnime.isNotEmpty()){
            //TODO:save to db
            return@withContext onlineAnime
        }

        //return db
        return@withContext null
    }

    suspend fun getAnimeByGenreApi(id: Int, pageNumber: Int):List<Anime> = jikanApi.getAnimeByGenre(id, pageNumber)
        ?.anime
        ?.map { it.convertToDomain() }
        .orEmpty()

    suspend fun getAnimeByGenreLocal(){
        daoAnime.getAnimesByGenre()
    }
}