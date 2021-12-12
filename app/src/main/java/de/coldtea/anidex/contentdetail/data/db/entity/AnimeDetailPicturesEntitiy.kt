package de.coldtea.anidex.contentdetail.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime_detail_pictures")
data class AnimeDetailPicturesEntitiy(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "anime_detail_picture_id")
    val animeDetailPictureId: Int = 0,
    @ColumnInfo(name = "fk_anime_id")
    val animeId: Int,
    @ColumnInfo(name = "large")
    val large: String,
    @ColumnInfo(name = "small")
    val small: String
)
