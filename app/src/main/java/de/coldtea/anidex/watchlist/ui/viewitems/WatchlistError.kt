package de.coldtea.anidex.watchlist.ui.viewitems

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.viewitems.FullMessageScreen
import java.lang.reflect.Modifier

@Composable
fun WatchlistError(
    modifier: Modifier = Modifier()
){
    FullMessageScreen(message = stringResource(R.string.watchlist_loading_error))
}