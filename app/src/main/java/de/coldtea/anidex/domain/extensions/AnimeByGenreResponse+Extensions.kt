package de.coldtea.anidex.domain.extensions

import de.coldtea.anidex.data.model.animesbygenre.AnimeResponse
import de.coldtea.anidex.domain.model.Anime

fun AnimeResponse?.convertToDomain() =
    Anime(
        id = this?.malId?:0,
        name = this?.title.orEmpty(),
        imageUrl = this?.imageUrl.orEmpty(),
        score = this?.score?:0.0,
        isBookmarked = false
    )