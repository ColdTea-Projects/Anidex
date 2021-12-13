package de.coldtea.anidex.character.ui.model

import de.coldtea.anidex.character.domain.model.Character

sealed class CharacterScreenState

object Loading: CharacterScreenState()
object Failed: CharacterScreenState()

data class Success(val character: Character): CharacterScreenState()