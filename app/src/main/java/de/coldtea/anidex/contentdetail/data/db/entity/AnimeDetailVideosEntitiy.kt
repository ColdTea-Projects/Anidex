package de.coldtea.anidex.contentdetail.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "anime_detail")
data class AnimeDetailVideosEntitiy(
    @ColumnInfo(name = "anime_id")
    val animeId: Int,
    @ColumnInfo(name = "url")
    val url: String
)
