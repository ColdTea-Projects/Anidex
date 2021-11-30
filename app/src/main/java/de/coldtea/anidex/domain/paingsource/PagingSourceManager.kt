package de.coldtea.anidex.domain.paingsource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import de.coldtea.anidex.data.JikanRepository
import de.coldtea.anidex.data.api.SharedPreferencesRepository
import de.coldtea.anidex.domain.model.Anime
import de.coldtea.anidex.domain.model.Genre
import de.coldtea.anidex.domain.paingsource.JikanPagingSource.Companion.PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.random.Random

class PagingSourceManager @Inject constructor(
    private val jikanRepository: JikanRepository,
    private val sharedPreferencesRepository: SharedPreferencesRepository
) {
    fun producePagers(): List<Pair<String, Flow<PagingData<Anime>>>> =
        randomizeOneAndGetGenres().sortedBy { it.genreName }.map { genre ->
            genre.genreName to Pager(PagingConfig(PAGE_SIZE)) {
                JikanPagingSource(jikanRepository = jikanRepository, genreId = genre.genreId)
            }.flow
        }

    fun randomizeOneAndGetGenres(): List<Genre> {
        val allGenres = Genre.values()
        val genres = sharedPreferencesRepository.lastFetchedGenres ?: return listOf()

        if(sharedPreferencesRepository.isGenreRandomized){
            val randomizeOrdinal = Random.nextInt(0, 4)
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

}