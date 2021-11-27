package de.coldtea.anidex.ui.content.contentgrid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import de.coldtea.anidex.R
import de.coldtea.anidex.ui.theme.deepOrange003
import de.coldtea.anidex.ui.theme.materialBlackT90

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
            .padding(start = 16.dp, top = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .height(height.dp)
            .width(width.dp)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )

    }
}