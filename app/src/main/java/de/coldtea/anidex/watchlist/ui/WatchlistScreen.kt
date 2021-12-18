package de.coldtea.anidex.watchlist.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.theme.deepOrange003
import de.coldtea.anidex.base.ui.theme.materialWhite
import de.coldtea.anidex.base.ui.viewitems.NetworkStateWrapper
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
    NetworkStateWrapper(
        backgroundColor = deepOrange003,
        foregroundColor = materialWhite,
        icon = R.drawable.ic_baseline_signal_wifi_off_24,
        text = "No internet connection :(",
        heightDp = 45,
        fontSizeSp = 20
    ) {
        when (screenState.value) {
            is Loading -> WatchlistLoading()
            is Success -> WatchlistSuccess(
                modifier = Modifier.fillMaxSize(),
                (screenState.value as Success).watchlist,
                onClicked = onClicked
            )
            is Failed -> WatchlistError()
        }
    }
}