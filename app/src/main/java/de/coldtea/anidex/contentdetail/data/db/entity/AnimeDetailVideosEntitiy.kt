package de.coldtea.anidex.contentdetail.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime_detail_videos")
data class AnimeDetailVideosEntitiy(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "anime_detail_video_id")
    val animeDetailVideoId: Int = 0,
    @ColumnInfo(name = "fk_anime_id")
    val animeId: Int,
    @ColumnInfo(name = "url")
    val url: String
)
