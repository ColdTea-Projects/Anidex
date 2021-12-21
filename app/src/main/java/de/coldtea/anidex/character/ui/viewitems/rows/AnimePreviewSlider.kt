package de.coldtea.anidex.character.ui.viewitems.rows

import androidx.compose.foundation.clickable
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
import de.coldtea.anidex.character.domain.model.AnimePreview

@Composable
fun AnimePreviewSlider(
    modifier: Modifier = Modifier,
    animePreview: List<AnimePreview>,
    onAnimeClicked: (Int) -> Unit
) {
    Column(modifier = modifier) {
        if (animePreview.isNotEmpty()) {
            Text(
                text = stringResource(R.string.preview_slider_appearence_header),
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            )
        }
        LazyRow(modifier = modifier) {
            items(animePreview) { anime ->
                PreviewCardDisplay(
                    modifier = Modifier.clickable {
                          onAnimeClicked(anime.animeId)
                    },
                    height = 180,
                    width = 115,
                    name = anime.name,
                    imageUrl = anime.imageUrl
                )
            }
        }
    }
}