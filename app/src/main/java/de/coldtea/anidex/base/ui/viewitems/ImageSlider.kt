package de.coldtea.anidex.base.ui.viewitems

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ImageSlider(
    modifier: Modifier = Modifier,
    imageUrls: List<String>,
    itemSpacingPadding: Int = 5,
    onImageClicked: (String) -> Unit
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(itemSpacingPadding.dp)
    ) {
        items(imageUrls) { imageUrl ->
            Image(
                contentScale = ContentScale.Fit,
                painter =
                rememberImagePainter(
                    data = imageUrl,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = "Image",
                modifier = Modifier
                    .height(280.dp)
                    .width(200.dp)
            )
        }
    }
}