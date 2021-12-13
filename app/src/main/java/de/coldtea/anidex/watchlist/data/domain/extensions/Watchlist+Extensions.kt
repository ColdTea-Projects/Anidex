package de.coldtea.anidex.watchlist.data.domain.extensions

import de.coldtea.anidex.watchlist.data.db.entity.WatchlistEntity
import de.coldtea.anidex.watchlist.data.domain.model.Watchlist

fun Watchlist.convertToEntity() =
    WatchlistEntity(
        animeId = animeId,
        name = name,
        imageUrl = imageUrl,
        score = score
    )