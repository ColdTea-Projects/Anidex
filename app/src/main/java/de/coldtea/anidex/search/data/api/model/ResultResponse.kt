package de.coldtea.anidex.search.data.api.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ResultResponse(
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("url")
    var url: String?,
    @SerialName("image_url")
    var imageUrl: String?,
    @SerialName("title")
    var title: String?,
    @SerialName("airing")
    var airing: Boolean?,
    @SerialName("synopsis")
    var synopsis: String?,
    @SerialName("type")
    var type: String?,
    @SerialName("episodes")
    var episodes: Int?,
    @SerialName("score")
    var score: Double?,
    @SerialName("start_date")
    var startDate: String?,
    @SerialName("end_date")
    var endDate: String?,
    @SerialName("members")
    var members: Int?,
    @SerialName("rated")
    var rated: String?
)