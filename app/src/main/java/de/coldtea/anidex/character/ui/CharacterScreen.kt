package de.coldtea.anidex.character.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.res.stringResource
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.theme.deepOrange003
import de.coldtea.anidex.base.ui.theme.materialWhite
import de.coldtea.anidex.base.ui.viewitems.FullScreenLoader
import de.coldtea.anidex.base.ui.viewitems.NetworkStateWrapper
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
    NetworkStateWrapper(
        backgroundColor = deepOrange003,
        foregroundColor = materialWhite,
        icon = R.drawable.ic_baseline_signal_wifi_off_24,
        text = stringResource(R.string.no_internet_error),
        heightDp = 45,
        fontSizeSp = 20
    ) {
        when (screenState.value) {
            is Loading -> FullScreenLoader()
            is Success -> CharacterSuccess(
                character = (screenState.value as Success).character
            ) {
                onAnimeClicked(it)
            }
            is Failed -> CharacterError {

            }
        }
    }
}