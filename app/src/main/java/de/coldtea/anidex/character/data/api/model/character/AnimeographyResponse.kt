package de.coldtea.anidex.character.data.api.model.character


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class AnimeographyResponse(
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("url")
    var url: String?,
    @SerialName("image_url")
    var imageUrl: String?,
    @SerialName("role")
    var role: String?
)