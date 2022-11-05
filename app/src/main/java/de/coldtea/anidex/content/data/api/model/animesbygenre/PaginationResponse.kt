package de.coldtea.anidex.content.data.api.model.animesbygenre


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaginationResponse(
    @SerialName("current_page")
    val currentPage: Int = 0,
    @SerialName("has_next_page")
    val hasNextPage: Boolean = false,
    @SerialName("items")
    val items: ItemsResponse = ItemsResponse(),
    @SerialName("last_visible_page")
    val lastVisiblePage: Int = 0
)