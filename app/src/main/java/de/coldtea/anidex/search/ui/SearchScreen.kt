package de.coldtea.anidex.search.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                    .height(50.dp),
                text = text,
                onTextChanged = { text = it },
                onSearchClicked = {
                    if(text.length < 3) return@SearchTopBar
                    viewModel.search(text)
                }
            )
        },
        content = {
            SearchResults(pagingState = viewModel.pagingState.collectAsState(), onItemClicked = onItemClicked)
        }
    )
}