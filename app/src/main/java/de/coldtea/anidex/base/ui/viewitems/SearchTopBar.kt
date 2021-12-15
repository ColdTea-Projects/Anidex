package de.coldtea.anidex.base.ui.viewitems

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
    val focusRequester = remember { FocusRequester() }

    Row(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .weight(7f)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxSize()
                    .focusRequester(focusRequester),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent
                ),
                value = text,
                onValueChange = onTextChanged,
                enabled = textEnabled,
                keyboardOptions = KeyboardOptions.Default.copy(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(onSearch = {
                    onSearchClicked()
                })
            )

        }

        Column(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSearchClicked()
                }
        ) {
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .padding(10.dp),
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = null,
                tint = Color.White
            )
        }
    }

    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { }
    }
}