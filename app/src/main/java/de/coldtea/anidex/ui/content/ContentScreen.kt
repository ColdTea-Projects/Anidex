package de.coldtea.anidex.ui.content

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import de.coldtea.anidex.domain.model.Anime
import de.coldtea.anidex.domain.paingsource.ActionPagingSource
import de.coldtea.anidex.ui.content.contentgrid.VerticalCardSlider
import kotlinx.coroutines.flow.Flow

@Composable
fun ContentScreen(
    animes: Flow<PagingData<Anime>>,
    onItemClicked: (id: Int) -> Unit
) {
    val lazyAnimeItems = animes.collectAsLazyPagingItems()

    VerticalCardSlider(
        title = ActionPagingSource.GENRE_NAME,
        animes = lazyAnimeItems,
        onItemClicked = onItemClicked
    )
}

