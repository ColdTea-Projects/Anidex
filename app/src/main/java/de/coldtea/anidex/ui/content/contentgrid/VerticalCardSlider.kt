package de.coldtea.anidex.ui.content.contentgrid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import de.coldtea.anidex.domain.model.Anime

@Composable
fun VerticalCardSlider(
    modifier: Modifier = Modifier,
    title: String,
    animes: LazyPagingItems<Anime>,
    onItemClicked: (id: Int) -> Unit,
    cardHeight: Int,
    cardWidth: Int
) {
    Column(modifier = modifier) {
        Text(text = title, Modifier.padding(start = 16.dp))
        LazyRow(content = {
            items(animes.itemCount) { index ->
                animes[index]?.let { item ->
                    CardDisplay(
                        height = cardHeight,
                        width = cardWidth,
                        name = item.name,
                        imageUrl = item.imageUrl,
                        isBookmarked = item.isBookmarked,
                        rate = item.rate,
                        onClickAction = {
                            onItemClicked(item.id)
                        }
                    )
                }
            }

            animes.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item { LoadingCard(height = cardHeight, width = cardWidth) }
                    }
                    loadState.append is LoadState.Loading -> {
                        item { LoadingCard(height = cardHeight, width = cardWidth) }
                    }
                    loadState.refresh is LoadState.Error -> {
//                        val e = loadState.refresh as LoadState.Error
                        item {
                            ErrorItem(
                                modifier = Modifier.fillParentMaxSize(),
                                onClickRetry = {
                                    retry()
                                }
                            )
                        }
                    }
                    loadState.append is LoadState.Error -> {
//                        val e = loadState.append as LoadState.Error
                        item {
                            ErrorItem(
                                onClickRetry = {
                                    retry()
                                }
                            )
                        }
                    }
                }
            }
        })
    }
}