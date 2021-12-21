package de.coldtea.anidex.contentdetail.ui.viewitems.rows

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.theme.gold001
import de.coldtea.anidex.contentdetail.domain.model.AnimeDetail

@Composable
fun AddWatchlistAndScore(
    modifier: Modifier = Modifier,
    bookmarkState: Boolean,
    animeDetail: AnimeDetail,
    onClickAddToWatchList: (Int) -> Unit
) {
    val bookmarkText = if (bookmarkState) {
        stringResource(R.string.remove_from_watchlist)
    } else {
        stringResource(R.string.add_to_watchlist)
    }

    val bookmarkIcon = if (bookmarkState) {
        R.drawable.ic_baseline_bookmark_added
    } else {
        R.drawable.ic_bokmark_outline
    }

    Row(
        modifier = modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Card(
            Modifier
                .clip(RoundedCornerShape(5.dp))
                .padding(end = 10.dp)
                .weight(2f)
                .clickable { onClickAddToWatchList(animeDetail.animeId) }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 5.dp, end = 2.dp),
                    painter = painterResource(id = bookmarkIcon),
                    contentDescription = null,
                    tint = Color.White
                )
                Text(text = bookmarkText, fontSize = 16.sp, modifier = Modifier.padding(5.dp))
            }
        }
        Card(
            Modifier
                .clip(RoundedCornerShape(5.dp))
                .weight(1.2f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 5.dp, end = 2.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_star_24),
                    contentDescription = null,
                    tint = gold001
                )
                Text(text = animeDetail.getScoreText(), fontSize = 16.sp, modifier = Modifier.padding(5.dp))
            }
        }
    }
}
