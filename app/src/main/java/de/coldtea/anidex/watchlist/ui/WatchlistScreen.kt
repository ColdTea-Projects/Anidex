package de.coldtea.anidex.watchlist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import de.coldtea.anidex.watchlist.data.ui.Failed
import de.coldtea.anidex.watchlist.data.ui.Loading
import de.coldtea.anidex.watchlist.data.ui.Success
import de.coldtea.anidex.watchlist.data.ui.WatchlistScreenState
import de.coldtea.anidex.watchlist.ui.viewitems.WatchlistError
import de.coldtea.anidex.watchlist.ui.viewitems.WatchlistLoading
import de.coldtea.anidex.watchlist.ui.viewitems.WatchlistSuccess

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