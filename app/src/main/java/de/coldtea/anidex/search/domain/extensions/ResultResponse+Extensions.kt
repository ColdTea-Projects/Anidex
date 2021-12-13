package de.coldtea.anidex.search.domain.extensions

import de.coldtea.anidex.base.data.extensions.orInvalidId
import de.coldtea.anidex.search.data.api.model.ResultResponse
import de.coldtea.anidex.search.domain.model.SearchResultAnime

fun ResultResponse.convertToDomain() =
    SearchResultAnime(
        animeId = malId.orInvalidId(),
        imageUrl = imageUrl.orEmpty(),
        title = title.orEmpty(),
        synopsis = synopsis.orEmpty()
    )