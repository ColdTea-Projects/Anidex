package de.coldtea.anidex.watchlist.data.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.coldtea.anidex.watchlist.data.db.extensions.convertToDomain
import de.coldtea.anidex.watchlist.data.domain.WatchlistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    private val watchlistRepository: WatchlistRepository
) : ViewModel() {

    private val _watchlistScreenState = MutableStateFlow<WatchlistScreenState>(Loading)
    val watchlistScreenState = _watchlistScreenState.asStateFlow()

    fun fetchWatchlist() = viewModelScope.launch(Dispatchers.IO) {
        try{
            val successState = Success(watchlistRepository.anidexDatabase.daoWatchlist.getWatchlist().map { it.convertToDomain() })
            _watchlistScreenState.emit(
                successState
            )
        }catch (ex: Exception){
            _watchlistScreenState.emit(Failed)
            Timber.d("Anidex --> $ex")
        }
    }
//    fun getMyList
}