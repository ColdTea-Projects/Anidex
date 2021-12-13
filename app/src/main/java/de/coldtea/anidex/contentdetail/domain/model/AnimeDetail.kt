package de.coldtea.anidex.contentdetail.domain.model

import de.coldtea.anidex.contentdetail.ui.model.MediaPagerItem
import de.coldtea.anidex.contentdetail.ui.model.PicturePagerItem
import de.coldtea.anidex.contentdetail.ui.model.VideoPagerItem

data class AnimeDetail(
    val animeId: Int,
    val title: String,
    val date: String,
    val imageUrl: String,
    val background: String,
    val duration: String,
    val rating: String,
    val score: Double,
    val genres: String,
    val producers: String,
    val episodes: Int,
    val characters: List<CharacterPreview>,
    val staff: List<StaffPreview>,
    val pictures: List<AnimePictures>,
    val videos: List<AnimeVideos>
) {
    fun getScoreText() = "$score/10"
    fun getTitleFooter() = "$rating - $episodes episodes, $duration"
    fun getGenreNames(): List<String> = genres.split(",")
    fun getMediaItems(): List<MediaPagerItem> =
        videos.map { VideoPagerItem(it) } + pictures.map { PicturePagerItem(it) }
}
