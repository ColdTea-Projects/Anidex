package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//TODO: Clean up
@Serializable
data class DataResponse(
    @SerialName("aired")
    val aired: AiredResponse = AiredResponse(),
    @SerialName("airing")
    val airing: Boolean = false,
    @SerialName("approved")
    val approved: Boolean = false,
    @SerialName("background")
    val background: String = "",
    @SerialName("broadcast")
    val broadcast: BroadcastResponse = BroadcastResponse(),
    @SerialName("demographics")
    val demographics: List<DemographicResponse> = listOf(),
    @SerialName("duration")
    val duration: String = "",
    @SerialName("episodes")
    val episodes: Int = 0,
    @SerialName("favorites")
    val favorites: Int = 0,
    @SerialName("genres")
    val genres: List<GenreResponse> = listOf(),
    @SerialName("images")
    val images: ImagesResponse = ImagesResponse(),
    @SerialName("licensors")
    val licensors: List<LicensorResponse> = listOf(),
    @SerialName("mal_id")
    val malId: Int = 0,
    @SerialName("members")
    val members: Int = 0,
    @SerialName("popularity")
    val popularity: Int = 0,
    @SerialName("producers")
    val producers: List<ProducerResponse> = listOf(),
    @SerialName("rank")
    val rank: Int = 0,
    @SerialName("rating")
    val rating: String = "",
    @SerialName("score")
    val score: Double = 0.0,
    @SerialName("scored_by")
    val scoredBy: Int = 0,
    @SerialName("season")
    val season: String = "",
    @SerialName("source")
    val source: String = "",
    @SerialName("status")
    val status: String = "",
    @SerialName("studios")
    val studios: List<StudioResponse> = listOf(),
    @SerialName("synopsis")
    val synopsis: String = "",
    @SerialName("themes")
    val themes: List<ThemeResponse> = listOf(),
    @SerialName("title")
    val title: String = "",
    @SerialName("title_english")
    val titleEnglish: String = "",
    @SerialName("title_japanese")
    val titleJapanese: String = "",
    @SerialName("title_synonyms")
    val titleSynonyms: List<String> = listOf(),
    @SerialName("titles")
    val titles: List<TitleResponse> = listOf(),
    @SerialName("trailer")
    val trailer: TrailerResponse = TrailerResponse(),
    @SerialName("type")
    val type: String = "",
    @SerialName("url")
    val url: String = "",
    @SerialName("year")
    val year: Int = 0
)