package de.coldtea.anidex.contentdetail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.theme.deepOrange003
import de.coldtea.anidex.base.ui.theme.materialWhite
import de.coldtea.anidex.base.ui.viewitems.FullScreenLoader
import de.coldtea.anidex.base.ui.viewitems.NetworkStateWrapper
import de.coldtea.anidex.contentdetail.ui.model.ContentDetailScreenState
import de.coldtea.anidex.contentdetail.ui.model.Failed
import de.coldtea.anidex.contentdetail.ui.model.Loading
import de.coldtea.anidex.contentdetail.ui.model.Success
import de.coldtea.anidex.contentdetail.ui.viewitems.ContentDetailError
import de.coldtea.anidex.contentdetail.ui.viewitems.ContentDetailSuccess

@Composable
fun ContentDetailScreen(
    screenState: State<ContentDetailScreenState>,
    bookmarkState: Boolean,
    onClickAddToWatchList: (Int) -> Unit,
    onCharacterClicked: (Int) -> Unit,
    onVideoClicked: (String) -> Unit,
    onImageClicked: (String) -> Unit
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
            is Loading -> FullScreenLoader()
            is Success -> ContentDetailSuccess(
                animeDetail = (screenState.value as Success).animeDetail,
                bookmarkState = bookmarkState,
                onClickAddToWatchList = onClickAddToWatchList,
                onCharacterClicked = onCharacterClicked,
                onVideoClicked = onVideoClicked,
                onImageClicked = onImageClicked
            )
            is Failed -> ContentDetailError {

            }
        }
    }
}