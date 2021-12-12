package de.coldtea.anidex.contentdetail.data.api.model.charactersandstaff


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class CharacterResponse(
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("url")
    var url: String?,
    @SerialName("image_url")
    var imageUrl: String?,
    @SerialName("name")
    var name: String?,
    @SerialName("role")
    var role: String?,
    @SerialName("voice_actors")
    var voiceActors: List<VoiceActorResponse>?
)