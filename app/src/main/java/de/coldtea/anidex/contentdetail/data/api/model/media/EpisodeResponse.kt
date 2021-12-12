package de.coldtea.anidex.contentdetail.data.api.model.media


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class EpisodeResponse(
    @SerialName("title")
    var title: String?,
    @SerialName("episode")
    var episode: String?,
    @SerialName("url")
    var url: String?,
    @SerialName("image_url")
    var imageUrl: String?
)