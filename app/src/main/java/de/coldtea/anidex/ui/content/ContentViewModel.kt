package de.coldtea.anidex.ui.content

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import de.coldtea.anidex.data.SharedPreferencesRepository
import de.coldtea.anidex.domain.model.Anime
import de.coldtea.anidex.domain.paingsource.ActionPagingSource
import de.coldtea.anidex.domain.paingsource.ActionPagingSource.Companion.PAGE_SIZE
import de.coldtea.anidex.domain.paingsource.DramaPagingSource
import de.coldtea.anidex.domain.paingsource.FantasyPagingSource
import de.coldtea.anidex.domain.paingsource.MilitaryPagingSource
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val actionPagingSource: ActionPagingSource,
    private val dramaPagingSource: DramaPagingSource,
    private val fantasyPagingSource: FantasyPagingSource,
    private val militaryPagingSource: MilitaryPagingSource,
    private val sharedPreferencesRepository: SharedPreferencesRepository
) : ViewModel() {

    var lastFetcedGenres: List<Int>?
        get() = sharedPreferencesRepository.lastFetchedGenres
        set(value) {
            sharedPreferencesRepository.lastFetchedGenres = value
        }

    override fun onCleared() {
        Timber.i("Cleared")
        super.onCleared()
    }

    fun getActionGenre(): Flow<PagingData<Anime>> {
        return Pager(PagingConfig(PAGE_SIZE)) { actionPagingSource }.flow
    }

    fun getDramaGenre(): Flow<PagingData<Anime>> {
        return Pager(PagingConfig(PAGE_SIZE)) { dramaPagingSource }.flow
    }

    fun getFantasyGenre(): Flow<PagingData<Anime>> {
        return Pager(PagingConfig(PAGE_SIZE)) { fantasyPagingSource }.flow
    }

    fun getMilitaryGenre(): Flow<PagingData<Anime>> {
        return Pager(PagingConfig(PAGE_SIZE)) { militaryPagingSource }.flow
    }
}