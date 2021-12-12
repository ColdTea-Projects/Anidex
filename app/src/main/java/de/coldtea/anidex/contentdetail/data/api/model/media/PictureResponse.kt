package de.coldtea.anidex.contentdetail.data.api.model.media


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class PictureResponse(
    @SerialName("large")
    var large: String?,
    @SerialName("small")
    var small: String?
)