package de.coldtea.anidex.content.ui.viewitems.contentgrid

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.coldtea.anidex.base.ui.theme.blueGray002
import de.coldtea.anidex.base.ui.theme.blueGrayDark
import de.coldtea.anidex.base.ui.theme.materialBlack

//https://cdn.myanimelist.net/images/anime/10/47347.jpg
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LoadingCardStripe(
    modifier: Modifier = Modifier,
    height: Int,
    width: Int,
    stripeSize: Int = 3
) {
    val initialColor = if(isSystemInDarkTheme()) blueGrayDark else blueGray002
    val duration = if(isSystemInDarkTheme()) 4_000 else 2_000

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = initialColor,
        targetValue = materialBlack,
        animationSpec = infiniteRepeatable(
            keyframes {
                durationMillis = duration
                initialColor at 0 with LinearEasing
                materialBlack at duration/2 with LinearEasing
                initialColor at duration
            }
        )
    )

    Row {
        for (i in 0..2) {
            Card(
                elevation = 20.dp,
                backgroundColor = color,
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

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_3
)
@Composable
fun PreviewLoadingCardLight(){
    LoadingCardStripe(height = 180, width = 115)
}

@Preview(
    showSystemUi = true,
    device = Devices.PIXEL_3,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun PreviewLoadingCardDark(){
    LoadingCardStripe(height = 180, width = 115)
}