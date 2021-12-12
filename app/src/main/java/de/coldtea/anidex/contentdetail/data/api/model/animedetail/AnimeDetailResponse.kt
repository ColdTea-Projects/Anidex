package de.coldtea.anidex.contentdetail.data.api.model.animedetail


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class AnimeDetailResponse(
    @SerialName("aired")
    var aired: AiredResponse?,
    @SerialName("airing")
    var airing: Boolean?,
    @SerialName("background")
    var background: String?,
    @SerialName("broadcast")
    var broadcast: String?,
    @SerialName("duration")
    var duration: String?,
    @SerialName("ending_themes")
    var endingThemes: List<String>?,
    @SerialName("episodes")
    var episodes: Int?,
    @SerialName("external_links")
    var externalLinks: List<ExternalLinkResponse>?,
    @SerialName("favorites")
    var favorites: Int?,
    @SerialName("genres")
    var genres: List<GenreResponse>?,
    @SerialName("image_url")
    var imageUrl: String?,
    @SerialName("licensors")
    var licensors: List<LicensorResponse>?,
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("members")
    var members: Int?,
    @SerialName("opening_themes")
    var openingThemes: List<String>?,
    @SerialName("popularity")
    var popularity: Int?,
    @SerialName("premiered")
    var premiered: String?,
    @SerialName("producers")
    var producers: List<ProducerResponse>?,
    @SerialName("rank")
    var rank: Int?,
    @SerialName("rating")
    var rating: String?,
    @SerialName("related")
    var related: RelatedResponse?,
    @SerialName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerialName("request_cached")
    var requestCached: Boolean?,
    @SerialName("request_hash")
    var requestHash: String?,
    @SerialName("score")
    var score: Double?,
    @SerialName("scored_by")
    var scoredBy: Int?,
    @SerialName("source")
    var source: String?,
    @SerialName("status")
    var status: String?,
    @SerialName("studios")
    var studios: List<StudioResponse>?,
    @SerialName("synopsis")
    var synopsis: String?,
    @SerialName("themes")
    var themes: List<ThemeResponse>?,
    @SerialName("title")
    var title: String?,
    @SerialName("title_english")
    var titleEnglish: String?,
    @SerialName("title_japanese")
    var titleJapanese: String?,
    @SerialName("title_synonyms")
    var titleSynonyms: List<String>?,
    @SerialName("trailer_url")
    var trailerUrl: String?,
    @SerialName("type")
    var type: String?,
    @SerialName("url")
    var url: String?
)