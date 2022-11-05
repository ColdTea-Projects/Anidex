package de.coldtea.anidex.content.ui.viewitems.contentgrid

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import de.coldtea.anidex.content.domain.model.Anime

@Composable
fun ContentShelf(
    sections: List<Pair<String, LazyPagingItems<Anime>>>,
    onItemClicked: (id: Int) -> Unit
) {
    val lazyListState = rememberLazyListState()

    LazyColumn(content = {
        itemsIndexed(sections) { _, item ->
            VerticalCardSlider(
                title = item.first,
                animes = item.second,
                onItemClicked = onItemClicked,
                cardHeight = 180,
                cardWidth = 115
            )
        }
    }, state = lazyListState)

}