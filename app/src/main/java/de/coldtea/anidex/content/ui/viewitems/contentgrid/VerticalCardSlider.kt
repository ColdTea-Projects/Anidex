package de.coldtea.anidex.content.ui.viewitems.contentgrid

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import de.coldtea.anidex.content.domain.model.Anime

@Composable
fun VerticalCardSlider(
    modifier: Modifier = Modifier,
    title: String,
    animes: LazyPagingItems<Anime>,
    onItemClicked: (id: Int) -> Unit,
    cardHeight: Int,
    cardWidth: Int
) {
    val scrollState = rememberLazyListState()
    Column(modifier = modifier.fillMaxWidth().height(230.dp)) {
        Text(text = title, Modifier.padding(start = 16.dp))
        LazyRow(
            state = scrollState,
            content = {
                items(animes){ anime ->
                    if(anime != null){
                        ContentCardDisplay(
                            modifier = modifier.clickable {
                                onItemClicked(anime.id)
                            },
                            height = cardHeight,
                            width = cardWidth,
                            name = anime.name,
                            imageUrl = anime.imageUrl,
                            isBookmarked = anime.isBookmarked,
                            rate = anime.rate
                        )
                    }
                }

                animes.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            item { LoadingCardStripe(height = cardHeight, width = cardWidth) }
                        }
                        loadState.append is LoadState.Loading -> {
                            item { LoadingCardStripe(height = cardHeight, width = cardWidth) }
                        }
                        loadState.refresh is LoadState.Error -> {
                            item {
                                ErrorItem(
                                    onClickRetry = {
                                        retry()
                                    },
                                    height = 180,
                                    width = 115
                                )
                            }
                        }
                        loadState.append is LoadState.Error -> {
                            item {
                                ErrorItem(
                                    onClickRetry = {
                                        retry()
                                    },
                                    height = 180,
                                    width = 115
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}