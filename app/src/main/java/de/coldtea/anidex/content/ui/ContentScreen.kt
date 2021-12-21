package de.coldtea.anidex.ui.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.theme.deepOrange003
import de.coldtea.anidex.base.ui.theme.materialWhite
import de.coldtea.anidex.base.ui.viewitems.NetworkStateWrapper
import de.coldtea.anidex.base.ui.viewitems.SearchTopBar
import de.coldtea.anidex.content.ui.ContentViewModel
import de.coldtea.anidex.content.ui.viewitems.contentgrid.ContentShelf

@Composable
fun ContentScreen(
    viewModel: ContentViewModel,
    onItemClicked: (id: Int) -> Unit,
    onSearchClicked: () -> Unit
) {
    val sections = viewModel.getGenrePagers().map {
        it.first to it.second.collectAsLazyPagingItems()
    }

    Scaffold(
        modifier = Modifier.background(Color.Red),
        topBar = {
            SearchTopBar(modifier = Modifier
                .height(50.dp)
                .clickable {
                    onSearchClicked()
                }, text = stringResource(R.string.search_bar_default), onTextChanged = {}, onSearchClicked = { onSearchClicked() }, textEnabled = false
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
                ContentShelf(sections = sections, onItemClicked = onItemClicked)
            }
        }
    )
}

