package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BroadcastResponse(
    @SerialName("day")
    val day: String = "",
    @SerialName("string")
    val string: String = "",
    @SerialName("time")
    val time: String = "",
    @SerialName("timezone")
    val timezone: String = ""
)