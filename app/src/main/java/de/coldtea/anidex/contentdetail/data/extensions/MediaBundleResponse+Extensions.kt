package de.coldtea.anidex.contentdetail.data.extensions

import de.coldtea.anidex.contentdetail.data.api.model.media.PictureBundleResponse
import de.coldtea.anidex.contentdetail.data.api.model.media.VideoBundleResponse
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailPicturesEntitiy
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailVideosEntitiy

fun PictureBundleResponse.extractPictures(animeId: Int): List<AnimeDetailPicturesEntitiy> =
    pictures?.map {
        AnimeDetailPicturesEntitiy(
            animeId = animeId,
            large = it.large.orEmpty(),
            small = it.small.orEmpty()
        )
    }.orEmpty()

fun VideoBundleResponse.extractVideos(animeId: Int): List<AnimeDetailVideosEntitiy> =
    promo?.map {
        AnimeDetailVideosEntitiy(
            animeId = animeId,
            url = it.videoUrl.orEmpty(),
            image = it.imageUrl.orEmpty()
        )
    }.orEmpty()