package de.coldtea.anidex.contentdetail.ui.viewitems.rows

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import de.coldtea.anidex.contentdetail.domain.model.AnimeDetail

@Composable
fun AnimeDetailHeader(
    modifier: Modifier = Modifier,
    animeDetail: AnimeDetail
){
    Row(modifier.fillMaxWidth()) {
        Text(
            text = animeDetail.title,
            fontSize = 40.sp,
            fontWeight = FontWeight.W500
        )
    }
    Row(modifier.fillMaxWidth()) {
        Text(
            text = animeDetail.getTitleFooter(),
            fontSize = 14.sp,
            fontWeight = FontWeight.W200
        )
    }
}