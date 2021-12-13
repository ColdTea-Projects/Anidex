package de.coldtea.anidex.character.data.api.model.media


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class CharacterPicturesResponse(
    @SerialName("request_hash")
    var requestHash: String?,
    @SerialName("request_cached")
    var requestCached: Boolean?,
    @SerialName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerialName("pictures")
    var pictures: List<PictureResponse>?
)