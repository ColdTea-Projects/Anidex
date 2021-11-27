package de.coldtea.anidex.ui.content.contentgrid

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import de.coldtea.anidex.domain.model.Anime

@Composable
fun VerticalCardSlider(
    modifier: Modifier = Modifier,
    title: String,
    animes: LazyPagingItems<Anime>,
    onItemClicked: (id: Int) -> Unit
){
    Column(modifier = modifier) {
        Text(text = title, Modifier.padding(start = 16.dp))
        LazyRow(content = {
            items(animes.itemCount) { index ->
                animes[index]?.let { item ->
                    CardDisplay(
                        height = 250,
                        width = 160,
                        name = item.name,
                        imageUrl = item.imageUrl,
                        isBookmarked = item.isBookmarked,
                        rate = item.score,
                        onClickAction = {
                            onItemClicked(item.id)
                        }
                    )
                }

            }
        })
    }
}