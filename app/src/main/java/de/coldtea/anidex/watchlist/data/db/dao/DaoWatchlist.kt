package de.coldtea.anidex.watchlist.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.base.data.db.DaoBase
import de.coldtea.anidex.watchlist.data.db.entity.WatchlistEntity

@Dao
interface DaoWatchlist: DaoBase<WatchlistEntity>{

    @Transaction
    @Query("SELECT * FROM watchlist")
    suspend fun getWatchlist(): List<WatchlistEntity>

    @Transaction
    @Query("SELECT * FROM watchlist WHERE anime_id = :animeId")
    suspend fun getWatchlistById(animeId: Int): List<WatchlistEntity>

    @Transaction
    @Query("DELETE FROM watchlist WHERE anime_id = :animeId")
    suspend fun deleteWatchlistById(animeId: Int)
}