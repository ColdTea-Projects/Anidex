package de.coldtea.anidex.domain.paingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import de.coldtea.anidex.data.JikanRepository
import de.coldtea.anidex.domain.extensions.convertToDomain
import de.coldtea.anidex.domain.model.Anime
import timber.log.Timber
import javax.inject.Inject

class DramaPagingSource @Inject constructor(
    private val jikanRepository: JikanRepository
) : PagingSource<Int, Anime>() {
    var page = 1

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int {
        return page
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        page = params.key ?: 1
        val results = try {
            jikanRepository.getAnimeByGenre(GENRE_ID, page)
        }catch (ex: java.lang.Exception){
            Timber.e("Anidex --> ActionPagingSource.load : ex")
            return LoadResult.Error(
                Exception("Empty result")
            )
        }

        return if (results == null) {
            LoadResult.Error(
                Exception("Empty result")
            )
        } else {
            LoadResult.Page(
                data = results.anime?.map { it.convertToDomain() }.orEmpty(),
                prevKey =
                if (page == 1) null
                else page - 1,
                nextKey = page.plus(1)
            )
        }
    }

    companion object{
        const val GENRE_ID = 8
        const val GENRE_NAME = "Drama"
        const val PAGE_SIZE = 50
    }
}