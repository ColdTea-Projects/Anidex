package de.coldtea.anidex.contentdetail.data.extensions

import de.coldtea.anidex.base.data.extensions.orInvalidId
import de.coldtea.anidex.base.data.extensions.orZero
import de.coldtea.anidex.contentdetail.data.api.model.animedetail.AnimeDetailResponse
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailEntity

fun AnimeDetailResponse.extractEntity(): AnimeDetailEntity {
    val date = aired?.from?:"..." + "-" + aired?.to?:"..."
    val genresText = genres?.filter { it.name != null }?.joinToString(",") { it.name.orEmpty() }
    val producersText = producers?.filter { it.name != null }?.joinToString(", ") { it.name.orEmpty() }

    return AnimeDetailEntity(
        animeId = malId.orInvalidId(),
                title = title.orEmpty(),
                date = date,
                imageUrl = imageUrl.orEmpty(),
                background = background.orEmpty(),
                duration = duration.orEmpty(),
                rating = rating.orEmpty(),
                score = score.orZero(),
                genres = genresText.orEmpty(),
                producers = producersText.orEmpty(),
                episodes = episodes.orZero()
    )
}