package de.coldtea.anidex.character.domain

import de.coldtea.anidex.character.data.CharacterRepository
import de.coldtea.anidex.character.domain.model.Character
import kotlinx.coroutines.delay

class AcquireCharacterUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend fun getCharacter(characterId: Int): Character {
        fetchAndStore(characterId)

        return characterRepository
            .getLocalCharacter(characterId)
            .convertToDomainObject()
    }

    private suspend fun fetchAndStore(characterId: Int) {
        val character = characterRepository.getCharacterResponse(characterId).also { delay(500) } ?: return
        val characterPictures = characterRepository.getCharacterPictures(characterId).also { delay(500) }

        characterRepository.saveCharacter(character)
        characterRepository.saveCharacterPictures(characterPictures, character.malId?:return)
    }
}