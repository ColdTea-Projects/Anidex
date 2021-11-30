package de.coldtea.anidex.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeResponse(
    @SerialName("airing_start")
    var airingStart: String?,
    @SerialName("demographic")
    var demographic: List<DemographicResponse>?,
    @SerialName("episodes")
    var episodes: Int?,
    @SerialName("explicit_genres")
    var explicitGenre: List<ExplicitGenreResponse>?,
    @SerialName("genre")
    var genre: List<GenreResponse>?,
    @SerialName("image_url")
    var imageUrl: String?,
    @SerialName("kids")
    var kids: Boolean?,
    @SerialName("licensors")
    var licensors: List<String>?,
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("members")
    var members: Int?,
    @SerialName("producers")
    var producers: List<ProducerResponse>?,
    @SerialName("r18")
    var r18: Boolean?,
    @SerialName("score")
    var score: Double?,
    @SerialName("source")
    var source: String?,
    @SerialName("synopsis")
    var synopsis: String?,
    @SerialName("themes")
    var themes: List<ThemeResponse>?,
    @SerialName("title")
    var title: String?,
    @SerialName("type")
    var type: String?,
    @SerialName("url")
    var url: String?
)