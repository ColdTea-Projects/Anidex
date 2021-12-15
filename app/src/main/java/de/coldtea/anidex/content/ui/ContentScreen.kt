package de.coldtea.anidex.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import de.coldtea.anidex.base.ui.viewitems.SearchTopBar
import de.coldtea.anidex.content.ui.ContentViewModel
import de.coldtea.anidex.content.ui.viewitems.contentgrid.ContentShelf

@Composable
fun ContentScreen(
    viewModel: ContentViewModel,
    onItemClicked: (id: Int) -> Unit,
    onSearchClicked: () -> Unit
) {
    val sections = viewModel.getGenrePagers().map {
        it.first to it.second.collectAsLazyPagingItems()
    }

    Scaffold(
        modifier = Modifier.background(Color.Red),
        topBar = {
            SearchTopBar(modifier = Modifier.height(50.dp).clickable {
                onSearchClicked()
            }, text = "Search...", onTextChanged = {}, onSearchClicked = { onSearchClicked() }, textEnabled = false)
        },
        content = {
            ContentShelf(sections = sections, onItemClicked = onItemClicked)
        }
    )
}

