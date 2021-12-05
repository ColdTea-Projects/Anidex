package de.coldtea.anidex.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "anime", primaryKeys = ["genre_id", "anime_id"])
data class AnimeEntity(
    @ColumnInfo(name = "anime_id")
    val animeId: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "genre_id")
    val genreId: Int,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "rate")
    val rate: Double,
    @ColumnInfo(name = "created_at")
    val createdAt: Long
)