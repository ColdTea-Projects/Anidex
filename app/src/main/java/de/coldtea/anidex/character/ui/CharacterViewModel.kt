package de.coldtea.anidex.character.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.coldtea.anidex.character.domain.CharacterRepository
import de.coldtea.anidex.character.ui.model.CharacterScreenState
import de.coldtea.anidex.character.ui.model.Failed
import de.coldtea.anidex.character.ui.model.Loading
import de.coldtea.anidex.character.ui.model.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
): ViewModel() {
    private val _characterScreenState = MutableStateFlow<CharacterScreenState>(Loading)
    val characterScreenState = _characterScreenState.asStateFlow()

    fun fetchCharacter(characterId: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            _characterScreenState.emit(
                Success(characterRepository.getCharacter(characterId))
            )
        }catch (ex: Exception){
            _characterScreenState.emit(Failed)
            Timber.w("Anidex --> $ex")
        }
    }
}