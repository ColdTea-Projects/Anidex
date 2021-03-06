package de.coldtea.anidex.contentdetail.domain

import de.coldtea.anidex.base.data.api.JikanApi
import de.coldtea.anidex.base.data.db.AnidexDatabase
import de.coldtea.anidex.contentdetail.data.db.relations.AnimeDetailBundle
import de.coldtea.anidex.contentdetail.data.extensions.extractCharacter
import de.coldtea.anidex.contentdetail.data.extensions.extractEntity
import de.coldtea.anidex.contentdetail.data.extensions.extractPictures
import de.coldtea.anidex.contentdetail.data.extensions.extractStaff
import de.coldtea.anidex.contentdetail.data.extensions.extractVideos
import de.coldtea.anidex.contentdetail.domain.model.AnimeDetail
import kotlinx.coroutines.delay
import timber.log.Timber
import javax.inject.Inject

class ContentDetailRepository @Inject constructor(
    val jikanApi: JikanApi,
    val anidexDatabase: AnidexDatabase
) {
    suspend fun getAnimeDetail(animeId: Int): AnimeDetail {
        fetchAndStore(animeId)

        return anidexDatabase
            .daoAnimeDetail
            .getAnimeDetails(animeId = animeId)
            .first()
            .convertToDomainObject()
    }

    private suspend fun fetchAndStore(animeId: Int) {
        val animeDetailResponse = getAnimeDetailResponse(animeId).also { delay(500) }
        val characterAndStaffResponse = getCharacterAndStaff(animeId).also { delay(500) }
        val picturesResponse = getPictures(animeId).also { delay(500) }
        val videosResponse = getVideos(animeId)

        animeDetailResponse?.let { response ->
            anidexDatabase.daoAnimeDetail.insert(response.extractEntity())
        }
        characterAndStaffResponse?.let { response ->
            anidexDatabase.daoCharacterPreview.insertAll(response.extractCharacter(animeId))
            anidexDatabase.daoStaffPreview.insertAll(response.extractStaff(animeId))
        }
        picturesResponse?.let { response ->
            anidexDatabase.daoAnimeDetailPictures.insertAll(response.extractPictures(animeId))
        }
        videosResponse?.let { response ->
            anidexDatabase.daoAnimeDetailVideos.insertAll(response.extractVideos(animeId))
        }
    }

    private suspend fun getAnimeDetailResponse(animeId: Int) = try {
        if (anidexDatabase.daoAnimeDetail.getAnimeCount(animeId) > 0) null
        else jikanApi.getAnimeDetailById(animeId)
    } catch (ex: Exception) {
        Timber.w("Anidex --> Anime detail response is empty!!")
        null
    }

    private suspend fun getCharacterAndStaff(animeId: Int) = try {
        if (anidexDatabase.daoCharacterPreview.getCharacterCount(animeId) > 0
            && anidexDatabase.daoStaffPreview.getStaffCount(animeId) > 0
        ) null
        else jikanApi.getCharactersAndStaff(animeId)
    } catch (ex: Exception) {
        Timber.w("Anidex --> Character and staff response is empty!!")
        null
    }

    private suspend fun getPictures(animeId: Int) = try {
        if (anidexDatabase.daoAnimeDetailPictures.getAnimeDetailPictureCount(animeId) > 0) null
        else jikanApi.getAnimeDetailPictures(animeId)
    } catch (ex: Exception) {
        Timber.w("Anidex --> Pictures response is empty!!")
        null
    }

    private suspend fun getVideos(animeId: Int) = try {
        if (anidexDatabase.daoAnimeDetailVideos.getAnimeDetailVideosCount(animeId) > 0) null
        else jikanApi.getAnimeDetailVideos(animeId)
    } catch (ex: Exception) {
        Timber.w("Anidex --> Videos response is empty!!")
        null
    }

    suspend fun getAnimeFromDB(animeId: Int): AnimeDetailBundle? = try {
        anidexDatabase.daoAnimeDetail.getAnimeDetails(animeId).first()
    } catch (ex: Exception) {
        Timber.w("Anidex --> Videos response is empty!!")
        null
    }

    suspend fun isBookmarked(animeId: Int) =
        anidexDatabase.daoWatchlist.getWatchlistById(animeId).isNotEmpty()

}