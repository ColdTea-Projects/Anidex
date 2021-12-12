package de.coldtea.anidex.contentdetail.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "anime_detail_videos", primaryKeys = ["url"])
data class AnimeDetailVideosEntitiy(
    @ColumnInfo(name = "fk_anime_id")
    val animeId: Int,
    @ColumnInfo(name = "url")
    val url: String
)
