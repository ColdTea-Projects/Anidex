package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrailerResponse(
    @SerialName("embed_url")
    val embedUrl: String = "",
    @SerialName("images")
    val images: ImagesResponseX = ImagesResponseX(),
    @SerialName("url")
    val url: String = "",
    @SerialName("youtube_id")
    val youtubeId: String = ""
)