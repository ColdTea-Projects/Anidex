package de.coldtea.anidex.contentdetail.ui.model

import de.coldtea.anidex.contentdetail.domain.model.AnimePictures
import de.coldtea.anidex.contentdetail.domain.model.AnimeVideos

sealed class MediaPagerItem

data class PicturePagerItem(val animePictures: AnimePictures): MediaPagerItem()
data class VideoPagerItem(val animeVideos: AnimeVideos): MediaPagerItem()
