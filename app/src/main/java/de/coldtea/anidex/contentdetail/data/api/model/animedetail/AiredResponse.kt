package de.coldtea.anidex.contentdetail.data.api.model.animedetail


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class AiredResponse(
    @SerialName("from")
    var from: String?,
    @SerialName("prop")
    var prop: PropResponse?,
    @SerialName("string")
    var string: String?,
    @SerialName("to")
    var to: String?
)