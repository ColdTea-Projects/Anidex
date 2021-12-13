package de.coldtea.anidex.character.domain.model

data class Character(
    val characterId: Int,
    val name: String,
    val nameKanji: String,
    val nicknames: String,
    val about: String,
    val animePreviews: List<AnimePreview>,
    val voiceActorPreviews: List<VoiceActorPreview>,
    val pictures: List<CharacterPicture>
)
