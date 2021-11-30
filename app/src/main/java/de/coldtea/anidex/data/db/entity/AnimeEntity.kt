package de.coldtea.anidex.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime")
data class AnimeEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "anime_id")
    val animeId: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "score")
    val score: Double,
    @ColumnInfo(name = "is_bookmarked")
    val isBookmarked: Boolean,
    @ColumnInfo(name = "created_at")
    val createdAt: Long
)