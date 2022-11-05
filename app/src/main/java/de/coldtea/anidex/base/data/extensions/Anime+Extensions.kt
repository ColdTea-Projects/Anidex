package de.coldtea.anidex.base.data.extensions

import de.coldtea.anidex.content.data.api.model.animesbygenre.DataResponse
import de.coldtea.anidex.content.data.api.model.animesbygenre.legacy.AnimeResponse
import de.coldtea.anidex.content.data.db.entity.AnimeEntity
import de.coldtea.anidex.content.domain.model.Anime

fun DataResponse.convertToEntity(genreId: Int) =
    AnimeEntity(
        animeId = malId,
        name = title,
        genreId = genreId,
        imageUrl = images.jpg.imageUrl,
        rate = score,
        createdAt = nowInMiliseconds
    )

fun AnimeEntity.convertToAnime(genreId: Int, isBookmarked: Boolean = false) =
    Anime(
        id = animeId,
        name = name,
        imageUrl = imageUrl,
        rate = rate,
        isBookmarked = isBookmarked,
        genreId = genreId
    )