package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TitleResponse(
    @SerialName("title")
    val title: String = "",
    @SerialName("type")
    val type: String = ""
)