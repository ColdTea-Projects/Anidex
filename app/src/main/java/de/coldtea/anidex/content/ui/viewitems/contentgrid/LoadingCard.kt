package de.coldtea.anidex.content.ui.viewitems.contentgrid

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//https://cdn.myanimelist.net/images/anime/10/47347.jpg
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LoadingCard(
    modifier: Modifier = Modifier,
    height: Int,
    width: Int
) {
    val infiniteTransition = rememberInfiniteTransition()
    val alphaChannel by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 0.3f,
        animationSpec = infiniteRepeatable(
            keyframes {
                durationMillis = 1500
                0.3f at 0 with LinearEasing
                1f at 750 with FastOutLinearInEasing
                0.3f at 1500
            }
        )
    )

    Row(
        Modifier.alpha(alphaChannel)
    ) {
        for (i in 0..3) {
            Card(
                elevation = 20.dp,
                backgroundColor = Color.Black,
                modifier =
                modifier
                    .padding(start = 6.dp, end = 6.dp, top = 12.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(height.dp)
                    .width(width.dp)
            ) {}
        }
    }

}

@Preview
@Composable
fun PreviewLoadingCard(){
    LoadingCard(height = 180, width = 115)
}