package de.coldtea.anidex.character.data.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import de.coldtea.anidex.character.data.db.entity.AnimePreviewEntity
import de.coldtea.anidex.character.data.db.entity.CharacterEntity
import de.coldtea.anidex.character.data.db.entity.CharacterPictureEntity
import de.coldtea.anidex.character.data.db.entity.VoiceActorPreviewEntity
import de.coldtea.anidex.character.domain.model.AnimePreview
import de.coldtea.anidex.character.domain.model.Character
import de.coldtea.anidex.character.domain.model.CharacterPicture
import de.coldtea.anidex.character.domain.model.VoiceActorPreview

data class CharacterBundle(
    @Embedded val character: CharacterEntity,

    @Relation(
        entity = AnimePreviewEntity::class,
        parentColumn = "character_id",
        entityColumn = "fk_character_id"
    )
    val animes: List<AnimePreviewEntity>,

    @Relation(
        entity = VoiceActorPreviewEntity::class,
        parentColumn = "character_id",
        entityColumn = "fk_character_id"
    )
    val voiceActors: List<VoiceActorPreviewEntity>,

    @Relation(
        entity = CharacterPictureEntity::class,
        parentColumn = "character_id",
        entityColumn = "fk_character_id"
    )
    val pictures: List<CharacterPictureEntity>
) {
    fun convertToDomainObject() = with(character) {
        Character(
            characterId = characterId,
            name = name,
            nameKanji = nameKanji,
            nicknames = nicknames,
            about = about,
            animePreviews = animes.map { it.convertToDomainObject() },
            voiceActorPreviews = voiceActors.map { it.convertToDomainObject() },
            pictures = pictures.map { it.convertToDomainObject() }
        )
    }

    fun AnimePreviewEntity.convertToDomainObject() =
        AnimePreview(
            animeId = animeId,
            name = name,
            url = url,
            imageUrl = imageUrl
        )

    fun VoiceActorPreviewEntity.convertToDomainObject() =
        VoiceActorPreview(
            voiceActorId = voiceActorId,
            name = name,
            imageUrl = imageUrl
        )

    fun CharacterPictureEntity.convertToDomainObject() =
        CharacterPicture(
            imageUrl = imageUrl
        )
}
