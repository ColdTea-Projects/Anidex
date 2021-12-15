package de.coldtea.anidex.character.domain

import de.coldtea.anidex.base.data.api.JikanApi
import de.coldtea.anidex.base.data.db.AnidexDatabase
import de.coldtea.anidex.character.data.api.model.character.CharacterResponse
import de.coldtea.anidex.character.data.api.model.media.CharacterPicturesResponse
import de.coldtea.anidex.character.data.extensions.extractAnimeographyEntity
import de.coldtea.anidex.character.data.extensions.extractEntity
import de.coldtea.anidex.character.data.extensions.extractVoiceActorEntity
import de.coldtea.anidex.character.domain.model.Character
import kotlinx.coroutines.delay
import timber.log.Timber
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    val jikanApi: JikanApi,
    val anidexDatabase: AnidexDatabase
) {
    suspend fun getCharacter(characterId: Int): Character {
        fetchAndStore(characterId)

        return anidexDatabase
            .daoCharacters
            .getCharacter(characterId)
            .first()
            .convertToDomainObject()
    }

    private suspend fun fetchAndStore(characterId: Int) {
        val character = getCharacterResponse(characterId).also { delay(500) }
        val characterPictures = getCharacterPictures(characterId).also { delay(500) }

        character?.apply {
            anidexDatabase.daoCharacters.insert(extractEntity())
            anidexDatabase.daoAnimePreview.insertAll(extractAnimeographyEntity(characterId))
            anidexDatabase.daoVoiceActorsPreview.insertAll(extractVoiceActorEntity(characterId))
        }

        characterPictures?.apply {
            anidexDatabase.daoCharacterPicture.insertAll(
                pictures?.map { it.extractEntity(characterId) }.orEmpty()
            )
        }
    }

    private suspend fun getCharacterResponse(characterId: Int): CharacterResponse? = try {
        if(anidexDatabase.daoCharacters.getCharacterCount(characterId) > 0) null
        else jikanApi.getCharacterById(characterId)
    } catch (ex: Exception) {
        Timber.w("Anidex --> Character response is empty!!")
        null
    }

    private suspend fun getCharacterPictures(characterId: Int): CharacterPicturesResponse? = try {
        if(anidexDatabase.daoCharacterPicture.getCharacterPictureCount(characterId) > 0) null
        else jikanApi.getCharcterPictures(characterId)
    } catch (ex: Exception) {
        Timber.w("Anidex --> Character picture response is empty!!")
        null
    }
}