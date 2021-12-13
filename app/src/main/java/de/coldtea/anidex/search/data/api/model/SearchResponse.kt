package de.coldtea.anidex.search.data.api.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchResponse(
    @SerialName("request_hash")
    var requestHash: String?,
    @SerialName("request_cached")
    var requestCached: Boolean?,
    @SerialName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerialName("results")
    var results: List<ResultResponse>?,
    @SerialName("last_page")
    var lastPage: Int?
)