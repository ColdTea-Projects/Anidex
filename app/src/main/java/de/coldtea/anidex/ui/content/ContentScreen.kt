package de.coldtea.anidex.ui.content

import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import de.coldtea.anidex.domain.paingsource.ActionPagingSource
import de.coldtea.anidex.domain.paingsource.DramaPagingSource
import de.coldtea.anidex.domain.paingsource.FantasyPagingSource
import de.coldtea.anidex.domain.paingsource.MilitaryPagingSource
import de.coldtea.anidex.ui.content.contentgrid.ContentShelf
import de.coldtea.anidex.ui.content.contentgrid.VerticalCardSlider

@Composable
fun ContentScreen(
    viewModel: ContentViewModel,
    onItemClicked: (id: Int) -> Unit
) {

    val sections = listOf(
        ActionPagingSource.GENRE_NAME to viewModel.getActionGenre().collectAsLazyPagingItems(),
        DramaPagingSource.GENRE_NAME to viewModel.getDramaGenre().collectAsLazyPagingItems(),
        FantasyPagingSource.GENRE_NAME to viewModel.getFantasyGenre().collectAsLazyPagingItems(),
        MilitaryPagingSource.GENRE_NAME to viewModel.getMilitaryGenre().collectAsLazyPagingItems()
    )

    ContentShelf(sections = sections, onItemClicked = onItemClicked)
}

