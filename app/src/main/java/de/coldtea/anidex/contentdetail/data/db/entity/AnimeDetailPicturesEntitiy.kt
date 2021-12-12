package de.coldtea.anidex.contentdetail.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "anime_detail")
data class AnimeDetailPicturesEntitiy(
    @ColumnInfo(name = "fk_anime_id")
    val animeId: Int,
    @ColumnInfo(name = "large")
    val large: String,
    @ColumnInfo(name = "small")
    val small: String
)
