package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImagesResponse(
    @SerialName("jpg")
    val jpg: JpgResponse = JpgResponse(),
    @SerialName("webp")
    val webp: WebpResponse = WebpResponse()
)