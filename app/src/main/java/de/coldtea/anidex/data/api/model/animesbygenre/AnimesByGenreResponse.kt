package de.coldtea.anidex.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimesByGenreResponse(
    @SerialName("anime")
    var anime: List<AnimeResponse>?,
    @SerialName("item_count")
    var itemCount: Int?,
    @SerialName("mal_url")
    var malUrl: MalUrlResponse?,
    @SerialName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerialName("request_cached")
    var requestCached: Boolean?,
    @SerialName("request_hash")
    var requestHash: String?
)