package de.coldtea.anidex.content.ui

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import de.coldtea.anidex.content.domain.model.Anime
import de.coldtea.anidex.content.domain.paingsource.PagingSourceManager
import kotlinx.coroutines.flow.Flow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(
    private val pagingSourceManager: PagingSourceManager
) : ViewModel() {
    private var genrePagers: List<Pair<String, Flow<PagingData<Anime>>>>? = null

    override fun onCleared() {
        Timber.i("Cleared")
        super.onCleared()
    }

    fun getGenrePagers() = genrePagers
        ?: pagingSourceManager
            .producePagers()
            .apply {
                genrePagers = this
            }

}