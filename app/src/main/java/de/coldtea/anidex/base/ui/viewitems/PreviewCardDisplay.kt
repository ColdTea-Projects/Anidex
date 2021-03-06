package de.coldtea.anidex.base.ui.viewitems

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.theme.materialBlackT90

@Composable
fun PreviewCardDisplay(
    modifier: Modifier = Modifier,
    height: Int,
    width: Int,
    name: String,
    imageUrl: String
) {
    Card(
        elevation = 20.dp,
        backgroundColor = Color.Black,
        modifier =
        modifier
            .padding(start = 6.dp, end = 6.dp, top = 12.dp)
            .clip(RoundedCornerShape(10.dp))
            .height(height.dp)
            .width(width.dp)
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
            contentDescription = stringResource(R.string.preview_card_image_item_content_desc),
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(
                    start = 0.dp, top = (height * 0.60).dp, 0.dp, 0.dp
                )
                .fillMaxSize()
                .background(materialBlackT90)
        ) {
            Row(modifier = Modifier.height((height * 0.25).dp)) {
                Text(
                    text = name,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

    }
}