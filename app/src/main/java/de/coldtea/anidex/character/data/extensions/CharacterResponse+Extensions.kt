package de.coldtea.anidex.character.data.extensions

import de.coldtea.anidex.base.data.extensions.orInvalidId
import de.coldtea.anidex.character.data.api.model.character.CharacterResponse
import de.coldtea.anidex.character.data.db.entity.AnimePreviewEntity
import de.coldtea.anidex.character.data.db.entity.CharacterEntity
import de.coldtea.anidex.character.data.db.entity.VoiceActorPreviewEntity

fun CharacterResponse.extractEntity(): CharacterEntity =
    CharacterEntity(
        characterId = malId.orInvalidId(),
        name = name.orEmpty(),
        nameKanji = nameKanji.orEmpty(),
        nicknames = nicknames?.joinToString(", ").orEmpty(),
        about = about.orEmpty()
    )

fun CharacterResponse.extractAnimeographyEntity(characterId: Int): List<AnimePreviewEntity> =
    animeography?.map {
        AnimePreviewEntity(
            animeId = malId.orInvalidId(),
            characterId = characterId,
            name = name.orEmpty(),
            url = url.orEmpty(),
            imageUrl = imageUrl.orEmpty()
        )
    }.orEmpty()

fun CharacterResponse.extractVoiceActorEntity(characterId: Int): List<VoiceActorPreviewEntity> =
    voiceActors?.map {
        VoiceActorPreviewEntity(
            voiceActorId = malId.orInvalidId(),
            characterId = characterId,
            name = name.orEmpty(),
            imageUrl = imageUrl.orEmpty()
        )
    }.orEmpty()