package de.coldtea.anidex.character.data

import de.coldtea.anidex.base.data.api.JikanApi
import de.coldtea.anidex.base.data.db.AnidexDatabase
import de.coldtea.anidex.character.data.api.model.character.CharacterResponse
import de.coldtea.anidex.character.data.api.model.media.CharacterPicturesResponse
import de.coldtea.anidex.character.data.db.relations.CharacterBundle
import de.coldtea.anidex.character.data.extensions.extractAnimeographyEntity
import de.coldtea.anidex.character.data.extensions.extractEntity
import de.coldtea.anidex.character.data.extensions.extractVoiceActorEntity
import timber.log.Timber
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    val jikanApi: JikanApi,
    val anidexDatabase: AnidexDatabase
) {
    suspend fun getCharacterResponse(characterId: Int): CharacterResponse? = try {
        if (anidexDatabase.daoCharacters.getCharacterCount(characterId) > 0) null
        else jikanApi.getCharacterById(characterId)
    } catch (ex: Exception) {
        Timber.w("Anidex --> Character response is empty!!")
        null
    }

    suspend fun getCharacterPictures(characterId: Int): CharacterPicturesResponse? = try {
        if (anidexDatabase.daoCharacterPicture.getCharacterPictureCount(characterId) > 0) null
        else jikanApi.getCharcterPictures(characterId)
    } catch (ex: Exception) {
        Timber.w("Anidex --> Character picture response is empty!!")
        null
    }

    suspend fun saveCharacter(characterResponse: CharacterResponse) = with(characterResponse) {
        val characterId = characterResponse.malId ?: return@with

        anidexDatabase.daoCharacters.insert(extractEntity())
        anidexDatabase.daoAnimePreview.insertAll(animeography?.map { it.extractAnimeographyEntity(characterId) }.orEmpty())
        anidexDatabase.daoVoiceActorsPreview.insertAll(voiceActors?.map { it.extractVoiceActorEntity(characterId) }.orEmpty())
    }

    suspend fun saveCharacterPictures(characterPicturesResponse: CharacterPicturesResponse?, characterId: Int) =
        characterPicturesResponse?.let { pictures ->
            anidexDatabase.daoCharacterPicture.insertAll(
                pictures.pictures?.map { it.extractEntity(characterId) }.orEmpty()
            )
        }

    suspend fun getLocalCharacter(characterId: Int): CharacterBundle = anidexDatabase
        .daoCharacters
        .getCharacter(characterId)
        .first()
}