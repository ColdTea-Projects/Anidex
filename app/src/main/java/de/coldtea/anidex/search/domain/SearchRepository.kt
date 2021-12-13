package de.coldtea.anidex.search.domain

import de.coldtea.anidex.base.data.api.JikanApi
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val jikanApi: JikanApi
) {

    suspend fun getSearchResult(q: String, page: Int) = jikanApi.getSearchResults(q, page)

    companion object{
        const val PAGE_SIZE = 100
    }
}