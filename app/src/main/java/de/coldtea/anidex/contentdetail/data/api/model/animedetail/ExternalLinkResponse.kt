package de.coldtea.anidex.contentdetail.data.api.model.animedetail


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ExternalLinkResponse(
    @SerialName("name")
    var name: String?,
    @SerialName("url")
    var url: String?
)