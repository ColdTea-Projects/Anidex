package de.coldtea.anidex.contentdetail.data.api.model.animedetail


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class PropResponse(
    @SerialName("from")
    var from: FromResponse?,
    @SerialName("to")
    var to: ToResponse?
)