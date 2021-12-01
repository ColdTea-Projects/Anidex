package de.coldtea.anidex.data.paging
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import de.coldtea.anidex.data.repo.JikanRepository
//import de.coldtea.anidex.domain.model.Anime
//import retrofit2.HttpException
//import timber.log.Timber
//
//class JikanPagingSource(
//    private val jikanRepository: JikanRepository,
//    private val genreId: Int
//) : PagingSource<Int, Anime>() {
//    var page = 1
//
//    override fun getRefreshKey(state: PagingState<Int, Anime>): Int {
//        return page
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
//        page = params.key ?: 1
//        val results = try {
//            jikanRepository.getAnimeByGenre(genreId, page)
//        }catch (exception: HttpException){
//            Timber.e("Anidex --> JikanPagingSourceJikanPagingSource.load: $exception")
//            return LoadResult.Error(
//                Exception("Empty result")
//            )
//        }catch (exception: HttpException){
//            Timber.e("Anidex --> JikanPagingSourceJikanPagingSource.load: $exception")
//            return LoadResult.Error(
//                Exception("Empty result")
//            )
//        }
//
//        return if (results == null) {
//            LoadResult.Error(
//                Exception("Empty result")
//            )
//        } else {
//            LoadResult.Page(
//                data = results,
//                prevKey =
//                if (page == 1) null
//                else page - 1,
//                nextKey = page.plus(1)
//            )
//        }
//    }
//
//}