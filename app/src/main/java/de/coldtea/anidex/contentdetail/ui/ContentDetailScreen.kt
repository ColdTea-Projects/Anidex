package de.coldtea.anidex.contentdetail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import de.coldtea.anidex.contentdetail.ui.model.ContentDetailScreenState
import de.coldtea.anidex.contentdetail.ui.model.Failed
import de.coldtea.anidex.contentdetail.ui.model.Loading
import de.coldtea.anidex.contentdetail.ui.model.Success
import de.coldtea.anidex.contentdetail.ui.viewitems.ContentDetailError
import de.coldtea.anidex.contentdetail.ui.viewitems.ContentDetailLoading
import de.coldtea.anidex.contentdetail.ui.viewitems.ContentDetailSuccess

@Composable
fun ContentDetailScreen(
    screenState: State<ContentDetailScreenState>,
    onClickAddToWatchList: (Int) -> Unit,
    onCharacterClicked: (Int) -> Unit,
    onStaffClicked: (Int) -> Unit
) {
    when (screenState.value) {
        is Loading -> ContentDetailLoading()
        is Success -> ContentDetailSuccess(
            animeDetail = (screenState.value as Success).animeDetail,
            onClickAddToWatchList = onClickAddToWatchList,
            onCharacterClicked = onCharacterClicked,
            onStaffClicked = onStaffClicked
        )
        is Failed -> ContentDetailError {

        }
    }
}