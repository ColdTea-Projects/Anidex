package de.coldtea.anidex.character.data.extensions

import de.coldtea.anidex.base.data.extensions.orInvalidId
import de.coldtea.anidex.character.data.api.model.character.AnimeographyResponse
import de.coldtea.anidex.character.data.api.model.character.CharacterResponse
import de.coldtea.anidex.character.data.api.model.character.VoiceActorResponse
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

fun AnimeographyResponse.extractAnimeographyEntity(characterId: Int): AnimePreviewEntity =
    AnimePreviewEntity(
        animeId = malId.orInvalidId(),
        characterId = characterId,
        name = name.orEmpty(),
        url = url.orEmpty(),
        imageUrl = imageUrl.orEmpty()
    )


fun VoiceActorResponse.extractVoiceActorEntity(characterId: Int): VoiceActorPreviewEntity =
        VoiceActorPreviewEntity(
            voiceActorId = malId.orInvalidId(),
            characterId = characterId,
            name = name.orEmpty(),
            imageUrl = imageUrl.orEmpty()
        )
