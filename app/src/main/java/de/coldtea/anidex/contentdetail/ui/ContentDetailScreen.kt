package de.coldtea.anidex.contentdetail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import timber.log.Timber

@Composable
fun ContentDetailScreen(
    viewModel: ContentDetailViewModel
){
    val screenState = viewModel.contentDetailScreenState.collectAsState()

    Timber.d(screenState.toString())
}