package de.coldtea.anidex.contentdetail.data.api.model.animedetail


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class RelatedResponse(
    @SerialName("Adaptation")
    var adaptation: List<AdaptationResponse>?,
    @SerialName("Side story")
    var sideStory: List<SideStoryResponse>?,
    @SerialName("Summary")
    var summary: List<SummaryResponse>?
)