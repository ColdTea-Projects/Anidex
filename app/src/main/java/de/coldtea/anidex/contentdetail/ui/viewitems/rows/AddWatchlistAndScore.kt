package de.coldtea.anidex.contentdetail.ui.viewitems.rows

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.coldtea.anidex.contentdetail.domain.model.AnimeDetail

@Composable
fun AddWatchlistAndScore(
    modifier: Modifier = Modifier,
    bookmarkState: Boolean,
    animeDetail: AnimeDetail,
    onClickAddToWatchList: (Int) -> Unit
){
    val bookmarkText = if(bookmarkState){" - Remove from Watchlist "}else{" + Add to Watchlist "}

    Row(
        modifier = modifier.padding(top = 20.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Card(
            Modifier
                .clip(RoundedCornerShape(5.dp))
                .padding(10.dp)
                .clickable{ onClickAddToWatchList(animeDetail.animeId) }
        ) {
            Text(text = bookmarkText, fontSize = 16.sp, modifier = Modifier.padding(5.dp))
        }
        Card(
            Modifier
                .clip(RoundedCornerShape(5.dp))
                .padding(10.dp)
                .clickable{ onClickAddToWatchList(animeDetail.animeId) }
        ) {
            Text(text = animeDetail.getScoreText(), fontSize = 16.sp, modifier = Modifier.padding(5.dp))
        }
    }
}
