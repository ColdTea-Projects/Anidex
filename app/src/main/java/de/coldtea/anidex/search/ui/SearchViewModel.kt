package de.coldtea.anidex.search.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import de.coldtea.anidex.search.domain.SearchRepository.Companion.PAGE_SIZE
import de.coldtea.anidex.search.domain.SearchResultSource
import de.coldtea.anidex.search.ui.model.Loading
import de.coldtea.anidex.search.ui.model.PagerReady
import de.coldtea.anidex.search.ui.model.SearchResultPagingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchResultSource: SearchResultSource
) : ViewModel() {
    private val _pagingState = MutableStateFlow<SearchResultPagingState>(Loading)
    val pagingState = _pagingState.asStateFlow()

    fun search(q: String) = viewModelScope.launch(Dispatchers.IO) {
        _pagingState.emit(
            PagerReady(
                Pager(PagingConfig(PAGE_SIZE)) { searchResultSource.apply { query = q } }.flow
            )
        )
    }
}