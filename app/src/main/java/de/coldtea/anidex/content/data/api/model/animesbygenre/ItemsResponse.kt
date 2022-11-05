package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemsResponse(
    @SerialName("count")
    val count: Int = 0,
    @SerialName("per_page")
    val perPage: Int = 0,
    @SerialName("total")
    val total: Int = 0
)