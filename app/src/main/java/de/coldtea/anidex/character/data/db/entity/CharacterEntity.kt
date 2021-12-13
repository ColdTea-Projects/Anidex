package de.coldtea.anidex.character.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "character", primaryKeys = ["character_id"])
data class CharacterEntity(
    @ColumnInfo(name = "character_id")
    val characterId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "name_kanji")
    val nameKanji: String,
    @ColumnInfo(name = "nicknames")
    val nicknames: String,
    @ColumnInfo(name = "about")
    val about: String
)
