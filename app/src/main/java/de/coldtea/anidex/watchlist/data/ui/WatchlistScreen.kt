package de.coldtea.anidex.watchlist.data.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import de.coldtea.anidex.watchlist.data.ui.viewitems.WatchlistError
import de.coldtea.anidex.watchlist.data.ui.viewitems.WatchlistLoading
import de.coldtea.anidex.watchlist.data.ui.viewitems.WatchlistSuccess

@Composable
fun WatchlistScreen(
    screenState: State<WatchlistScreenState>,
    onClicked: (Int) -> Unit
) {
    when (screenState.value) {
        is Loading -> WatchlistLoading()
        is Success -> WatchlistSuccess(
            modifier = Modifier.fillMaxSize(),
            (screenState.value as Success).watchlist,
            onClicked = onClicked
        )
        is Failed -> WatchlistError {

        }
    }
}