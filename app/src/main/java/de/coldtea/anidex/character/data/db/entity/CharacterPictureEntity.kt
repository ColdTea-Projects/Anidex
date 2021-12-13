package de.coldtea.anidex.character.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "character_picture", primaryKeys = ["image_url"])
data class CharacterPictureEntity(
    @ColumnInfo(name = "fk_character_id")
    val characterId: Int,
    @ColumnInfo(name = "image_url")
    val imageUrl: String
)
