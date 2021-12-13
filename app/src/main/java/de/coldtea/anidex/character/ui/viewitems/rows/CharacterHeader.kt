package de.coldtea.anidex.character.ui.viewitems

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.coldtea.anidex.base.ui.theme.deepOrange003

@Composable
fun CharacterHeader (
    modifier: Modifier = Modifier,
    name: String,
    nameKanji: String,
    nicknames: String
){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = name,
            fontSize = 25.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(end = 5.dp)
        )
        Text(
            text = nameKanji,
            fontSize = 15.sp,
            fontWeight = FontWeight.W500,
            color = deepOrange003
        )

    }
    Row(modifier.fillMaxWidth()) {
        Text(
            text = nicknames,
            fontSize = 14.sp,
            fontWeight = FontWeight.W200
        )
    }
}