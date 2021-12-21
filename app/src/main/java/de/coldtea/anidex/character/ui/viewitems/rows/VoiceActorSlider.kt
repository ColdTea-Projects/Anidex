package de.coldtea.anidex.character.ui.viewitems.rows

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import de.coldtea.anidex.R
import de.coldtea.anidex.base.ui.viewitems.PreviewCardDisplay
import de.coldtea.anidex.character.domain.model.VoiceActorPreview

@Composable
fun VoiceActorSlider(
    modifier: Modifier = Modifier,
    voiceActors: List<VoiceActorPreview>
) {
    Column(modifier = modifier) {
        if (voiceActors.isNotEmpty()) {
            Text(
                text = stringResource(R.string.preview_slider_voice_actors_header),
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            )
        }
        LazyRow(modifier = modifier) {
            items(voiceActors) { staff ->
                PreviewCardDisplay(
                    height = 180,
                    width = 115,
                    name = staff.name,
                    imageUrl = staff.imageUrl
                )
            }
        }
    }
}