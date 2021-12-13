package de.coldtea.anidex.character.ui.viewitems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.coldtea.anidex.base.ui.viewitems.ImageSlider
import de.coldtea.anidex.character.domain.model.Character
import de.coldtea.anidex.character.ui.viewitems.rows.AboutPane
import de.coldtea.anidex.character.ui.viewitems.rows.AnimePreviewSlider
import de.coldtea.anidex.character.ui.viewitems.rows.VoiceActorSlider

@Composable
fun CharacterSuccess(
    modifier:Modifier = Modifier,
    character: Character,
    onAnimeClicked: (Int) -> Unit
){
    val scrollState = rememberScrollState()
    val imageUrls = character.pictures.map { it.imageUrl }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .padding(20.dp)
    ) {
        CharacterHeader(
            name = character.name,
            nameKanji = character.nameKanji,
            nicknames = character.nicknames
        )
        ImageSlider(modifier = Modifier.padding(top = 10.dp), imageUrls = imageUrls){}
        AboutPane(modifier = Modifier.padding(top = 10.dp), about = character.about)
        AnimePreviewSlider(modifier = Modifier.padding(top = 10.dp), animePreview = character.animePreviews, onAnimeClicked = onAnimeClicked)
        VoiceActorSlider(modifier = Modifier.padding(top = 10.dp), voiceActors = character.voiceActorPreviews)
    }
}