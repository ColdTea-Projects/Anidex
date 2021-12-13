package de.coldtea.anidex.watchlist.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "watchlist", primaryKeys = ["anime_id"])
data class WatchlistEntity(
    @ColumnInfo(name = "anime_id")
    val animeId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "score")
    val score: Double
)
