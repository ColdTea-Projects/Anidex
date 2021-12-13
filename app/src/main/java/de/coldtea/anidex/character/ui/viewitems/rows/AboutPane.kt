package de.coldtea.anidex.character.ui.viewitems.rows

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun AboutPane(
    modifier: Modifier = Modifier,
    about: String
){
    Row{
        Text(modifier = modifier, text = about, fontSize = 14.sp)
    }
}