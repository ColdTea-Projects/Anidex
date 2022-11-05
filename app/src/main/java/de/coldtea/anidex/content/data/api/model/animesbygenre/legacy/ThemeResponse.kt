package de.coldtea.anidex.content.data.api.model.animesbygenre.legacy


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThemeResponse(
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("type")
    var type: String?,
    @SerialName("url")
    var url: String?
)