package de.coldtea.anidex.contentdetail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import de.coldtea.anidex.base.ui.viewitems.FullScreenLoader
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