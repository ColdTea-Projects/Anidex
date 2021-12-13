package de.coldtea.anidex.search.ui.model

import androidx.paging.PagingData
import de.coldtea.anidex.search.data.api.model.ResultResponse
import kotlinx.coroutines.flow.Flow

sealed class SearchResultPagingState

object Loading: SearchResultPagingState()

data class PagerReady(val flow: Flow<PagingData<ResultResponse>>): SearchResultPagingState()
