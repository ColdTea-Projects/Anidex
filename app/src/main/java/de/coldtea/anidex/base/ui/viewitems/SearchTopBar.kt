package de.coldtea.anidex.base.ui.viewitems

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.coldtea.anidex.R

@Composable
fun SearchTopBar(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    onSearchClicked: () -> Unit,
    textEnabled: Boolean = true
) {
    Row(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight()
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxSize(),
                value = text,
                onValueChange = onTextChanged,
                enabled = textEnabled
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .fillMaxHeight()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        onSearchClicked()
                    },
                tint = Color.White
            )
        }
    }
}