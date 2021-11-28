package de.coldtea.anidex.ui.content.contentgrid

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import de.coldtea.anidex.domain.model.Anime

@Composable
fun ContentShelf(sections: List<Pair<String, LazyPagingItems<Anime>>>, onItemClicked: (id: Int) -> Unit){
    val lazyListState = rememberLazyListState()
    LazyColumn(content = {
        itemsIndexed(sections){ _, item ->
            VerticalCardSlider(
                title = item.first,
                animes = item.second,
                onItemClicked = onItemClicked
            )
        }
    }, state = lazyListState)

}