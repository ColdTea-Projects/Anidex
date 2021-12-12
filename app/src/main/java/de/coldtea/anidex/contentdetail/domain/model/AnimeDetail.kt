package de.coldtea.anidex.contentdetail.domain.model

data class AnimeDetail(
    val animeId: Int,//
    val title: String,//
    val date: String,//
    val imageUrl: String,//
    val background: String,//
    val duration: String,//
    val rating: String,//
    val score: Double,//
    val genres: String,//
    val producers: String,//
    val episodes: Int,//
    val characters: List<CharacterPreview>,
    val staff: List<StaffPreview>,
    val pictures: List<AnimePictures>,
    val videos: List<AnimeVideos>
){
    fun getScoreText() = "$score/10"
    fun getTitleFooter() = "$rating - $episodes episodes, $duration"
    fun getGenreNames(): List<String> = genres.split(",")
}
