package de.coldtea.anidex.base.data.extensions

import de.coldtea.anidex.content.data.api.model.animesbygenre.AnimeResponse
import de.coldtea.anidex.content.data.db.entity.AnimeEntity
import de.coldtea.anidex.content.domain.model.Anime

fun AnimeResponse.convertToEntity(genreId: Int) =
    AnimeEntity(
        animeId = malId ?: -1,
        name = title.orEmpty(),
        genreId = genreId,
        imageUrl = imageUrl.orEmpty(),
        rate = score ?: 0.0,
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