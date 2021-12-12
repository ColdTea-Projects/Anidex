package de.coldtea.anidex.contentdetail.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "anime_detail", primaryKeys = ["anime_id"])
data class AnimeDetailEntity(
    @ColumnInfo(name = "anime_id")
    val animeId: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "background")
    val background: String,
    @ColumnInfo(name = "duration")
    val duration: String,
    @ColumnInfo(name = "rating")
    val rating: String,
    @ColumnInfo(name = "score")
    val score: Double,
    @ColumnInfo(name = "genres")
    val genres: String,
    @ColumnInfo(name = "producers")
    val producers: String,
    @ColumnInfo(name = "episodes")
    val episodes: Int
)