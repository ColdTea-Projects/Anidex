package de.coldtea.anidex.search.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import de.coldtea.anidex.search.data.api.model.ResultResponse

class SearchResultSource(
    private val searchRepository: SearchRepository
) : PagingSource<Int, ResultResponse>() {

    private var nextPage = 1
    var query: String = ""

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, ResultResponse> = kotlin.runCatching {
        nextPage = params.key ?: 1
        val results = searchRepository
            .getSearchResult(query, nextPage)
            .results

        return if (results == null) {
            LoadResult.Error(
                Exception("Empty result")
            )
        } else {
            LoadResult.Page(
                data = results,
                prevKey =
                if (nextPage == 1) null
                else nextPage - 1,
                nextKey = nextPage.plus(1)
            )
        }
    }.getOrElse {
        LoadResult.Error(
            Exception("Empty result")
        )
    }

    override fun getRefreshKey(state: PagingState<Int, ResultResponse>): Int? {
        return nextPage
    }
}