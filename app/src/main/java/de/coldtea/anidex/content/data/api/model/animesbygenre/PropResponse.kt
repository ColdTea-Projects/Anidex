package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PropResponse(
    @SerialName("from")
    val from: FromResponse = FromResponse(),
    @SerialName("to")
    val to: ToResponse = ToResponse()
)