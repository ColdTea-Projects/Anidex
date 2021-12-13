package de.coldtea.anidex.character.data.api.model.media


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class PictureResponse(
    @SerialName("image_url")
    var imageUrl: String?
)