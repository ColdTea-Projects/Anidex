package de.coldtea.anidex.domain.paingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import de.coldtea.anidex.data.api.SharedPreferencesRepository
import de.coldtea.anidex.data.extensions.convertToAnime
import de.coldtea.anidex.data.paging.JikanRemoteMediator
import de.coldtea.anidex.data.repo.JikanRepository
import de.coldtea.anidex.domain.model.Anime
import de.coldtea.anidex.domain.model.AnimeGenre
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.random.Random

@OptIn(ExperimentalPagingApi::class)
class PagingSourceManager @Inject constructor(
    private val jikanRepository: JikanRepository,
    private val sharedPreferencesRepository: SharedPreferencesRepository
) {
    fun producePagers(): List<Pair<String, Flow<PagingData<Anime>>>> =
        randomizeOneAndGetAnimeGenres().sortedBy { it.genreName }.map { genre ->
            genre.genreName to Pager(
                config = PagingConfig(
                    pageSize = PAGE_SIZE,
                    enablePlaceholders = false
                ),
                remoteMediator = JikanRemoteMediator(
                    genreId = genre.genreId,
                    api = jikanRepository.jikanApi,
                    db = jikanRepository.anidexDatabase
                ),
                pagingSourceFactory = { jikanRepository.getAnimesByGenre(genre.genreId) }
            ).flow.map { pagingData ->
                pagingData.map {
                    it.convertToAnime(it.genreId)
                }
            }
        }

    private fun randomizeOneAndGetAnimeGenres(): List<AnimeGenre> {
        val allGenres = AnimeGenre.values()
        val genres = sharedPreferencesRepository.lastFetchedGenres ?: return listOf()

        if(sharedPreferencesRepository.isGenreRandomized){
            val randomizeOrdinal = Random.nextInt(0, 9)
            var randomizedGenre: Int

            do {
                randomizedGenre = Random.nextInt(0, allGenres.size)
            } while (genres.contains(allGenres[randomizedGenre].genreId))

            val updatedGenres = genres.toMutableList()
            updatedGenres[randomizeOrdinal] = allGenres[randomizedGenre].genreId
            sharedPreferencesRepository.lastFetchedGenres = updatedGenres.toList()
            sharedPreferencesRepository.isGenreRandomized = false
        }

        return sharedPreferencesRepository.lastFetchedGenres?.map { genreId ->
            allGenres.first { it.genreId == genreId }
        }.orEmpty()
    }

    companion object{
        const val PAGE_SIZE = 100
        const val RESPECTFUL_WAIT_TIME = 2_000L
    }
}