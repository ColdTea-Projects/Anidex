package de.coldtea.anidex.character.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import de.coldtea.anidex.base.ui.viewitems.FullScreenLoader
import de.coldtea.anidex.character.ui.model.CharacterScreenState
import de.coldtea.anidex.character.ui.model.Failed
import de.coldtea.anidex.character.ui.model.Loading
import de.coldtea.anidex.character.ui.model.Success
import de.coldtea.anidex.character.ui.viewitems.CharacterError
import de.coldtea.anidex.character.ui.viewitems.CharacterSuccess

@Composable
fun CharacterScreen(
    screenState: State<CharacterScreenState>,
    onAnimeClicked: (Int) -> Unit
) {
    when (screenState.value) {
        is Loading -> FullScreenLoader()
        is Success -> CharacterSuccess(
            character = (screenState.value as Success).character
        ){
            onAnimeClicked(it)
        }
        is Failed -> CharacterError {

        }
    }
}