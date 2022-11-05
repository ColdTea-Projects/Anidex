package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AiredResponse(
    @SerialName("from")
    val from: String = "",
    @SerialName("prop")
    val prop: PropResponse = PropResponse(),
    @SerialName("string")
    val string: String = "",
    @SerialName("to")
    val to: String = ""
)