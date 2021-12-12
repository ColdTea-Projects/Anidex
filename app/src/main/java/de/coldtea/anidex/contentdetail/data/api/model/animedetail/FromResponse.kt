package de.coldtea.anidex.contentdetail.data.api.model.animedetail


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class FromResponse(
    @SerialName("day")
    var day: Int?,
    @SerialName("month")
    var month: Int?,
    @SerialName("year")
    var year: Int?
)