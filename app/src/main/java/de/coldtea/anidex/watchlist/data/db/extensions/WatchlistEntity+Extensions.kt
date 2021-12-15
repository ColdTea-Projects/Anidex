package de.coldtea.anidex.watchlist.data.db.extensions

import de.coldtea.anidex.watchlist.data.db.entity.WatchlistEntity
import de.coldtea.anidex.watchlist.domain.model.Watchlist

fun WatchlistEntity.convertToDomain() =
    Watchlist(
        animeId = animeId,
        name = name,
        imageUrl = imageUrl,
        score = score
    )