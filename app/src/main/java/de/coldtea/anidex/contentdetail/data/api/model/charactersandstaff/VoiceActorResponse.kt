package de.coldtea.anidex.contentdetail.data.api.model.charactersandstaff


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class VoiceActorResponse(
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("url")
    var url: String?,
    @SerialName("image_url")
    var imageUrl: String?,
    @SerialName("language")
    var language: String?
)