package de.coldtea.anidex.content.domain.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import de.coldtea.anidex.base.data.api.JikanApi
import de.coldtea.anidex.base.data.db.AnidexDatabase
import de.coldtea.anidex.base.data.extensions.convertToEntity
import de.coldtea.anidex.content.data.db.entity.AnimeEntity
import de.coldtea.anidex.content.data.db.entity.AnimePageKeysEntity
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class JikanRemoteMediator(
    private val genreId: Int,
    private val jikanApi: JikanApi,
    private val anidexDatabase: AnidexDatabase
) : RemoteMediator<Int, AnimeEntity>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, AnimeEntity>): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> {
                val pageKeys = getPageKeyClosestToCurrentPosition(state)
                pageKeys?.nextKey?.minus(1) ?: 1
            }
            LoadType.PREPEND -> {
                val pageKeys = getPageKeyForFirstItem(state = state)
                val prevKey = pageKeys?.prevKey

                if (prevKey == null) {
                    return MediatorResult.Success(endOfPaginationReached = pageKeys != null)
                }

                prevKey
            }
            LoadType.APPEND -> {
                val pageKeys = getPageKeyForLastItem(state = state)
                val nextKey = pageKeys?.nextKey

                if (nextKey == null) {
                    return MediatorResult.Success(endOfPaginationReached = pageKeys != null)
                }

                nextKey
            }
            else -> 1
        }

        try {
            val count = anidexDatabase.daoAnimePageKeys.getAnimeCountForPage(genreId, page + 1)

            if(count == 0){
                val apiResponse = jikanApi.getAnimeByGenre(genreId, page)
                val animes = apiResponse?.data
                val endOfPaginationReached = animes.isNullOrEmpty()
                anidexDatabase.withTransaction {
                    // clear all tables in the database
                    if (loadType == LoadType.REFRESH) {
                        anidexDatabase.daoAnimePageKeys.clearAnimePageKeysByGenre(genreId)
                        anidexDatabase.daoAnime.clearAllByGenre(genreId)
                    }
                    val prevKey = if (page == 1) null else page - 1
                    val nextKey = if (endOfPaginationReached) null else page + 1
                    val keys = animes?.map {
                        AnimePageKeysEntity(genreId = genreId, animeId = it.malId?: -1 , prevKey = prevKey, nextKey = nextKey)
                    }

                    anidexDatabase.daoAnimePageKeys.insertAll(keys.orEmpty())
                    anidexDatabase.daoAnime.insertAll(animes?.map { it.convertToEntity(genreId) }.orEmpty())
                }

                return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
            }

            return MediatorResult.Success(endOfPaginationReached = false)
        } catch (exception: IOException) {
            return MediatorResult.Error(exception)
        } catch (exception: HttpException) {
            return MediatorResult.Error(exception)
        }
    }

    private suspend fun getPageKeyForLastItem(state: PagingState<Int, AnimeEntity>): AnimePageKeysEntity? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { anime ->
                anidexDatabase.daoAnimePageKeys.getAnimePageKeys(anime.animeId, genreId)
            }
    }

    private suspend fun getPageKeyForFirstItem(state: PagingState<Int, AnimeEntity>): AnimePageKeysEntity? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { anime ->
                anidexDatabase.daoAnimePageKeys.getAnimePageKeys(anime.animeId, genreId)
            }
    }

    private suspend fun getPageKeyClosestToCurrentPosition(state: PagingState<Int, AnimeEntity>): AnimePageKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.animeId?.let { animeId ->
                anidexDatabase.daoAnimePageKeys.getAnimePageKeys(animeId = animeId, genreId = genreId)
            }
        }
    }

}