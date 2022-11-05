package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DemographicResponse(
    @SerialName("mal_id")
    val malId: Int = 0,
    @SerialName("name")
    val name: String = "",
    @SerialName("type")
    val type: String = "",
    @SerialName("url")
    val url: String = ""
)