package de.coldtea.anidex.search.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import de.coldtea.anidex.R

@Composable
fun SearchResultRow(
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit,
    animeId: Int,
    imageUrl: String,
    title: String,
    synopsis: String
){
    Row(modifier = modifier.clickable { onItemClicked(animeId) }) {
        Card(
            elevation = 20.dp,
            backgroundColor = Color.Black,
            modifier =
            modifier
                .padding(start = 6.dp, end = 6.dp, top = 12.dp)
                .clip(RoundedCornerShape(10.dp))
                .height(180.dp)
                .width(115.dp)
        ) {
            Image(
                contentScale = ContentScale.Fit,
                painter =
                rememberImagePainter(
                    data = imageUrl,
                    builder = {
                        placeholder(
                            R.drawable.ic_anime
                        )
                        crossfade(true)
                    }
                ),
                contentDescription = stringResource(R.string.search_result_image_desc),
                modifier = Modifier
                    .fillMaxSize()
            )
        }


        Column {
            Text(text = title, fontSize = 12.sp, fontWeight = W500, modifier = Modifier.padding(top = 10.dp))
            Text(
                text = synopsis,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 10.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 5
            )
        }
    }
}