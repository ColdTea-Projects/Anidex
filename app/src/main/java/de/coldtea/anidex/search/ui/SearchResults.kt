package de.coldtea.anidex.search.ui

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import de.coldtea.anidex.search.domain.extensions.convertToDomain
import de.coldtea.anidex.search.ui.model.PagerReady
import de.coldtea.anidex.search.ui.model.SearchResultPagingState

@Composable
fun SearchResults(
    modifier: Modifier = Modifier,
    pagingState: State<SearchResultPagingState>,
    onItemClicked: (Int) -> Unit
) {
    when(pagingState.value){
        is PagerReady -> {
            val results = (pagingState.value as PagerReady).flow.collectAsLazyPagingItems()

            LazyColumn(modifier.fillMaxHeight()){
                items(results){ resultRes ->
                    with(resultRes?.convertToDomain()?:return@items){
                        SearchResultRow(
                            onItemClicked = onItemClicked,
                            animeId = animeId,
                            imageUrl = imageUrl,
                            title = title,
                            synopsis = synopsis
                        )
                    }
                }
            }
        }
    }

}