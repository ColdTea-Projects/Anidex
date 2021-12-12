package de.coldtea.anidex.contentdetail.data.api.model.animedetail


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class AdaptationResponse(
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("type")
    var type: String?,
    @SerialName("url")
    var url: String?
)