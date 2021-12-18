package de.coldtea.anidex.contentdetail.ui.viewitems.rows

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import de.coldtea.anidex.base.ui.viewitems.PreviewCardDisplay
import de.coldtea.anidex.content.ui.viewitems.contentgrid.LoadingCardStripe
import de.coldtea.anidex.contentdetail.domain.model.CharacterPreview

@Composable
fun CharacterSlider(
    modifier: Modifier = Modifier,
    characters: List<CharacterPreview>,
    onCharacterClicked: (Int) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = "Characters",
            fontSize = 20.sp,
            fontWeight = FontWeight.W500
        )
        if (characters.size > 0) {
            LazyRow {
                items(characters) { character ->
                    PreviewCardDisplay(
                        modifier = Modifier.clickable { onCharacterClicked(character.characterId) },
                        height = 180,
                        width = 115,
                        name = character.name,
                        imageUrl = character.imageUrl
                    )
                }
            }
        } else {
            LoadingCardStripe(
                height = 180,
                width = 115
            )
        }

    }
}