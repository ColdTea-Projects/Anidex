package de.coldtea.anidex.character.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "voice_actor_preview", primaryKeys = ["voice_actor_id"])
data class VoiceActorPreviewEntity(
    @ColumnInfo(name = "voice_actor_id")
    val voiceActorId: Int,
    @ColumnInfo(name = "fk_character_id")
    val characterId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String
)
