package de.coldtea.anidex.watchlist.data.domain

import de.coldtea.anidex.base.data.db.AnidexDatabase
import de.coldtea.anidex.watchlist.data.db.extensions.convertToDomain
import de.coldtea.anidex.watchlist.data.domain.extensions.convertToEntity
import de.coldtea.anidex.watchlist.data.domain.model.Watchlist
import javax.inject.Inject

class WatchlistRepository @Inject constructor(
    val anidexDatabase: AnidexDatabase
) {
    suspend fun bookmark(watchlist: Watchlist) =
        anidexDatabase.daoWatchlist.insert(watchlist.convertToEntity())

    suspend fun removeBookmark(animeId: Int) =
        anidexDatabase.daoWatchlist.deleteWatchlistById(animeId)

    suspend fun getWatchlist(): List<Watchlist> =
        anidexDatabase.daoWatchlist.getWatchlist().map { it.convertToDomain() }

    suspend fun getWatchlistItem(animeId: Int): Watchlist =
        anidexDatabase.daoWatchlist.getWatchlistById(animeId).first().convertToDomain()
}