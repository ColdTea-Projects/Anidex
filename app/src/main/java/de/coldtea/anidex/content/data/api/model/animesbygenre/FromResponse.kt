package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FromResponse(
    @SerialName("day")
    val day: Int = 0,
    @SerialName("month")
    val month: Int = 0,
    @SerialName("year")
    val year: Int = 0
)