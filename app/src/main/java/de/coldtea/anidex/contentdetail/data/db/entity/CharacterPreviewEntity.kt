package de.coldtea.anidex.contentdetail.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "character_preview", primaryKeys = ["character_id"])
data class CharacterPreviewEntity(
    @ColumnInfo(name = "character_id")
    val characterId: Int,
    @ColumnInfo(name = "fk_anime_id")
    val animeId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String
)