package de.coldtea.anidex.character.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "anime_preview", primaryKeys = ["anime_id"])
data class AnimePreviewEntity(
    @ColumnInfo(name = "anime_id")
    val animeId: Int,
    @ColumnInfo(name = "fk_character_id")
    val characterId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String
)
