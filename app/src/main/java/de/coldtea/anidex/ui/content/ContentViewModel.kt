package de.coldtea.anidex.ui.content

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.coldtea.anidex.domain.paingsource.PagingSourceManager
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val pagingSourceManager: PagingSourceManager
) : ViewModel() {

    override fun onCleared() {
        Timber.i("Cleared")
        super.onCleared()
    }

    fun getGenrePagers() = pagingSourceManager.producePagers()

}