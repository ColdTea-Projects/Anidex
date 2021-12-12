package de.coldtea.anidex.contentdetail.data.api.model.charactersandstaff


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class CharacterStaffResponse(
    @SerialName("request_hash")
    var requestHash: String?,
    @SerialName("request_cached")
    var requestCached: Boolean?,
    @SerialName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerialName("characters")
    var characters: List<CharacterResponse>?,
    @SerialName("staff")
    var staff: List<StaffResponse>?
)