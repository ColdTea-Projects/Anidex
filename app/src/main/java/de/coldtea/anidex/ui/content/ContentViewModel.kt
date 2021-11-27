package de.coldtea.anidex.ui.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import de.coldtea.anidex.domain.JikanRepository
import de.coldtea.anidex.domain.model.Anime
import de.coldtea.anidex.domain.paingsource.ActionPagingSource
import de.coldtea.anidex.domain.paingsource.ActionPagingSource.Companion.PAGE_SIZE
import de.coldtea.anidex.ui.content.model.ContentScreenState
import de.coldtea.anidex.ui.content.model.GenreLoaded
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val actionPagingSource: ActionPagingSource
) : ViewModel() {
    override fun onCleared() {
        Timber.i("Cleared")
        super.onCleared()
    }

    fun getActionGenre(): Flow<PagingData<Anime>> {
        return Pager(PagingConfig(PAGE_SIZE)) { actionPagingSource }.flow
    }
}