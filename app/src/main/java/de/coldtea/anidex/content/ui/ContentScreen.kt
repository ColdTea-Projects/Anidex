package de.coldtea.anidex.ui.content

import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import de.coldtea.anidex.content.ui.ContentViewModel
import de.coldtea.anidex.content.ui.contentgrid.ContentShelf

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

