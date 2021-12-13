package de.coldtea.anidex.contentdetail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.coldtea.anidex.contentdetail.domain.ContentDetailRepository
import de.coldtea.anidex.contentdetail.ui.model.ContentDetailScreenState
import de.coldtea.anidex.contentdetail.ui.model.Failed
import de.coldtea.anidex.contentdetail.ui.model.Loading
import de.coldtea.anidex.contentdetail.ui.model.Success
import de.coldtea.anidex.watchlist.data.domain.WatchlistRepository
import de.coldtea.anidex.watchlist.data.domain.model.Watchlist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ContentDetailViewModel @Inject constructor(
    private val contentDetailRepository: ContentDetailRepository,
    private val watchlistRepository: WatchlistRepository
) : ViewModel() {
    private val _contentDetailScreenState = MutableStateFlow<ContentDetailScreenState>(Loading)
    val contentDetailScreenState = _contentDetailScreenState.asStateFlow()

    private val _isBookmarked = MutableStateFlow(false)
    val isBookmarked = _isBookmarked.asStateFlow()

    fun fetchAnimeDetail(animeId: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            _contentDetailScreenState.emit(
                Success(contentDetailRepository.getAnimeDetail(animeId))
            )
        } catch (ex: Exception) {
            _contentDetailScreenState.emit(Failed)
            Timber.w("Anidex --> $ex")
        }

    }

    fun bookmark(animeId: Int) = viewModelScope.launch(Dispatchers.IO) {
        val anime = contentDetailRepository.getAnimeFromDB(animeId)?.animeDetail ?: return@launch
        val isBookmarked = contentDetailRepository.isBookmarked(animeId)
        if (isBookmarked) {
            watchlistRepository.removeBookmark(animeId)
        } else {
            watchlistRepository.bookmark(
                Watchlist(
                    animeId = anime.animeId,
                    name = anime.title,
                    imageUrl = anime.imageUrl,
                    score = anime.score
                )
            )
        }

        _isBookmarked.emit(!isBookmarked)
    }

    fun checkBookmarked(animeId: Int) = viewModelScope.launch(Dispatchers.IO) {
        _isBookmarked.emit(contentDetailRepository.isBookmarked(animeId))
    }
}