package de.coldtea.anidex.ui.content.contentgrid

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.coldtea.anidex.R

@Composable
fun ErrorItem(
    modifier: Modifier = Modifier,
    onClickRetry: () -> Unit,
    height: Int,
    width: Int,
    iconSize: Dp = (width / 3).dp
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
            .clickable(onClick = onClickRetry)
    ) {
        Box(Modifier.wrapContentSize(Alignment.Center)) {
            Box(modifier = Modifier.size(iconSize)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_retry),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.White
                )
            }
        }
    }
}