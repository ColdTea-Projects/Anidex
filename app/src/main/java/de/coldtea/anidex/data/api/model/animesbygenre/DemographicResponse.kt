package de.coldtea.anidex.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DemographicResponse(
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("type")
    var type: String?,
    @SerialName("url")
    var url: String?
)