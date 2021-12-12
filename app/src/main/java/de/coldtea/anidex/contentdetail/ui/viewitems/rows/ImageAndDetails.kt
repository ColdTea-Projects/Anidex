package de.coldtea.anidex.contentdetail.ui.viewitems.rows

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import de.coldtea.anidex.R
import de.coldtea.anidex.contentdetail.domain.model.AnimeDetail

@Composable
fun ImageAndDetails(
    modifier: Modifier = Modifier,
    animeDetail: AnimeDetail
){
    Row(
        modifier
            .fillMaxWidth()
            .padding(top = 20.dp)) {
        Column(Modifier.padding(end = 10.dp)) {
            Image(
                contentScale = ContentScale.Fit,
                painter =
                rememberImagePainter(
                    data = animeDetail.imageUrl,
                    builder = {
                        placeholder(
                            R.drawable.ic_anime
                        )
                        crossfade(true)
                    }
                ),
                contentDescription = "Image",
                modifier = Modifier
                    .height(180.dp)
                    .width(115.dp)
            )
        }
        Column {
            LazyRow(){
                items(animeDetail.getGenreNames()){ genre ->
                    Card(
                        Modifier
                            .padding(end = 3.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .height(20.dp)) {
                        Text(text = genre, fontSize = 12.sp, modifier = Modifier.padding(3.dp))
                    }
                }
            }

            Text(text = animeDetail.background, fontSize = 12.sp, modifier = Modifier.padding(top = 10.dp))
            Text(text = animeDetail.producers, fontSize = 12.sp, modifier = Modifier.padding(top = 10.dp))
        }
    }
}