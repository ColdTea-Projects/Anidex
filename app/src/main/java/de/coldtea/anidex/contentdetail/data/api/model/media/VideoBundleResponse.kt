package de.coldtea.anidex.contentdetail.data.api.model.media


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class VideoBundleResponse(
    @SerialName("request_hash")
    var requestHash: String?,
    @SerialName("request_cached")
    var requestCached: Boolean?,
    @SerialName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerialName("promo")
    var promo: List<PromoResponse>?,
    @SerialName("episodes")
    var episodes: List<EpisodeResponse>?
)