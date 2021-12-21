package de.coldtea.anidex.search.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.theme.deepOrange003
import de.coldtea.anidex.base.ui.theme.materialWhite
import de.coldtea.anidex.base.ui.viewitems.NetworkStateWrapper
import de.coldtea.anidex.base.ui.viewitems.SearchTopBar

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    onItemClicked: (Int) -> Unit
) {
    var text by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            SearchTopBar(
                modifier = Modifier
                    .height(60.dp),
                text = text,
                onTextChanged = { text = it },
                onSearchClicked = {
                    if (text.length < 3) return@SearchTopBar
                    viewModel.search(text)
                }
            )
        },
        content = {
            NetworkStateWrapper(
                backgroundColor = deepOrange003,
                foregroundColor = materialWhite,
                icon = R.drawable.ic_baseline_signal_wifi_off_24,
                text = stringResource(R.string.no_internet_error),
                heightDp = 45,
                fontSizeSp = 20
            ) {
                SearchResults(pagingState = viewModel.pagingState.collectAsState(), onItemClicked = onItemClicked)
            }
        }
    )
}