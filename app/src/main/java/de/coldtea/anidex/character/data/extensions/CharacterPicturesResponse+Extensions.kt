package de.coldtea.anidex.character.data.extensions

import de.coldtea.anidex.character.data.api.model.media.PictureResponse
import de.coldtea.anidex.character.data.db.entity.CharacterPictureEntity

fun PictureResponse.extractEntity(characterId: Int): CharacterPictureEntity =
    CharacterPictureEntity(
        characterId = characterId,
        imageUrl = imageUrl.orEmpty()
    )