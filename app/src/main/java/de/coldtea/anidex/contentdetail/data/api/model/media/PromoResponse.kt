package de.coldtea.anidex.contentdetail.data.api.model.media


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class PromoResponse(
    @SerialName("title")
    var title: String?,
    @SerialName("image_url")
    var imageUrl: String?,
    @SerialName("video_url")
    var videoUrl: String?
)