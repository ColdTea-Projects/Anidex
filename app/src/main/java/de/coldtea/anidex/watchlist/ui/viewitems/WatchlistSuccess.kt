package de.coldtea.anidex.watchlist.ui.viewitems

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.coldtea.anidex.watchlist.domain.model.Watchlist

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WatchlistSuccess(
    modifier: Modifier = Modifier,
    watchlist: List<Watchlist>,
    onClicked: (Int) -> Unit
) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
    ){
        items(watchlist){ anime ->
            WatchlistAnimeCardDisplay(
                modifier = Modifier.clickable { onClicked(anime.animeId) },
                height = 180,
                width = 115,
                name = anime.name,
                imageUrl = anime.imageUrl,
                rate = anime.score
            )

        }
    }
}