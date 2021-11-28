package de.coldtea.anidex.ui.content

import android.content.SharedPreferences
import androidx.compose.material.Text
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

    viewModel.lastFetcedGenres = listOf(1, 8, 10, 38)
    //ContentShelf(sections = sections, onItemClicked = onItemClicked)
}

