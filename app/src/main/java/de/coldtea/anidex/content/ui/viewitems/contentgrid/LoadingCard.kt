package de.coldtea.anidex.content.ui.viewitems.contentgrid

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//https://cdn.myanimelist.net/images/anime/10/47347.jpg
@Composable
fun LoadingCard(
    modifier: Modifier = Modifier,
    height: Int,
    width: Int
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
        CircularProgressIndicator(
            modifier = Modifier.fillMaxWidth()
                .padding((16).dp)
                .wrapContentSize(Alignment.Center)
        )

    }
}