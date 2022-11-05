package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimesByGenreResponse(
    @SerialName("data")
    val `data`: List<DataResponse> = listOf(),
    @SerialName("pagination")
    val pagination: PaginationResponse = PaginationResponse()
)