package de.coldtea.anidex.ui.content

import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import de.coldtea.anidex.domain.model.Anime
import de.coldtea.anidex.ui.content.contentgrid.ContentShelf

@Composable
fun ContentScreen(
    viewModel: ContentViewModel,
    onItemClicked: (id: Int) -> Unit
) {
    val sections = viewModel.getGenrePagers().map {
        it.first to it.second.collectAsLazyPagingItems()
    }

    ContentShelf(sections = sections, onItemClicked = onItemClicked)
}

