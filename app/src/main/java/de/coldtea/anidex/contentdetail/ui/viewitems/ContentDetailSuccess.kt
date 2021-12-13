package de.coldtea.anidex.contentdetail.ui.viewitems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.coldtea.anidex.contentdetail.domain.model.AnimeDetail
import de.coldtea.anidex.contentdetail.ui.viewitems.rows.AddWatchlistAndScore
import de.coldtea.anidex.contentdetail.ui.viewitems.rows.AnimeDetailHeader
import de.coldtea.anidex.contentdetail.ui.viewitems.rows.CharacterSlider
import de.coldtea.anidex.contentdetail.ui.viewitems.rows.ImageAndDetails
import de.coldtea.anidex.contentdetail.ui.viewitems.rows.MediaPager
import de.coldtea.anidex.contentdetail.ui.viewitems.rows.StaffSlider

@Composable
fun ContentDetailSuccess(
    modifier: Modifier = Modifier,
    bookmarkState: Boolean,
    animeDetail: AnimeDetail,
    onClickAddToWatchList: (Int) -> Unit,
    onCharacterClicked: (Int) -> Unit,
    onVideoClicked: (String) -> Unit,
    onImageClicked: (String) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .padding(20.dp)
    ) {
        MediaPager(mediaItems = animeDetail.getMediaItems(), onVideoClicked = onVideoClicked, onImageClicked = onImageClicked)
        AnimeDetailHeader(animeDetail = animeDetail)
        ImageAndDetails(animeDetail = animeDetail)
        AddWatchlistAndScore(animeDetail = animeDetail, onClickAddToWatchList = onClickAddToWatchList, bookmarkState = bookmarkState)
        CharacterSlider(modifier = Modifier
            .padding(top = 20.dp), characters = animeDetail.characters, onCharacterClicked = onCharacterClicked)
        StaffSlider(modifier = Modifier
            .padding(top = 20.dp), staff = animeDetail.staff)
    }
}