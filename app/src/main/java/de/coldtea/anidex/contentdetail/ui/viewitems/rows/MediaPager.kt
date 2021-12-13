package de.coldtea.anidex.contentdetail.ui.viewitems.rows

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.theme.materialWhite
import de.coldtea.anidex.contentdetail.ui.model.MediaPagerItem
import de.coldtea.anidex.contentdetail.ui.model.PicturePagerItem
import de.coldtea.anidex.contentdetail.ui.model.VideoPagerItem

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MediaPager(
    modifier: Modifier = Modifier,
    mediaItems: List<MediaPagerItem>,
    onVideoClicked: (String) -> Unit,
    onImageClicked: (String) -> Unit
) {
    HorizontalPager(
        count = mediaItems.size, modifier = modifier
            .fillMaxWidth()
    ) { page ->
        when (mediaItems[page]) {
            is PicturePagerItem -> {
                val picture = mediaItems[page] as PicturePagerItem

                Image(
                    contentScale = ContentScale.Crop,
                    painter =
                    rememberImagePainter(
                        data = picture.animePictures.large,
                        builder = {
                            placeholder(
                                R.drawable.ic_anime
                            )
                            crossfade(true)
                        }
                    ),
                    contentDescription = "Image",
                    modifier = Modifier.height(250.dp)
                )
            }
            is VideoPagerItem -> {
                val video = mediaItems[page] as VideoPagerItem
                Box(
                    modifier = Modifier.height(250.dp).fillMaxWidth()
                ) {
                    Image(
                        contentScale = ContentScale.Fit,
                        painter =
                        rememberImagePainter(
                            data = video.animeVideos.image
                        ),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_baseline_play_circle_outline_24
                        ),
                        contentDescription = "Bookmark",
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable { onVideoClicked(video.animeVideos.url) }
                            .padding(50.dp),
                        tint = materialWhite
                    )

                }
            }
        }

    }
}