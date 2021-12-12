package de.coldtea.anidex.contentdetail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.coldtea.anidex.contentdetail.domain.ContentDetailRepository
import de.coldtea.anidex.contentdetail.ui.model.ContentDetailScreenState
import de.coldtea.anidex.contentdetail.ui.model.Loading
import de.coldtea.anidex.contentdetail.ui.model.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ContentDetailViewModel @Inject constructor(
    private val contentDetailRepository: ContentDetailRepository
): ViewModel() {
    private val _contentDetailScreenState = MutableStateFlow<ContentDetailScreenState>(Loading)
    val contentDetailScreenState = _contentDetailScreenState.asStateFlow()

    fun fetchAnimeDetail(animeId: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            _contentDetailScreenState.emit(
                Success(contentDetailRepository.getAnimeDetail(animeId))
            )
        }catch (ex: Exception){
            Timber.w("Anidex --> $ex")
        }

    }
}