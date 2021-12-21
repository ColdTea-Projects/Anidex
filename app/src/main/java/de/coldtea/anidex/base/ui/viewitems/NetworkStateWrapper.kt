package de.coldtea.anidex.base.ui.viewitems

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.coldtea.anidex.R
import de.coldtea.anidex.base.domain.connectivity.ConnectionState
import de.coldtea.anidex.base.domain.connectivity.NetworkManager.connectivityState
import de.coldtea.anidex.base.ui.theme.deepOrange003
import de.coldtea.anidex.base.ui.theme.materialWhite
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun NetworkStateWrapper(
    backgroundColor: Color,
    foregroundColor: Color,
    @DrawableRes icon: Int,
    text: String,
    heightDp: Int,
    fontSizeSp: Int,
    content: @Composable () -> Unit
) {
    val connection by connectivityState()

    Column(
    ) {
        if (connection == ConnectionState.Offline) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(heightDp.dp)
                    .background(backgroundColor),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(
                        id = icon
                    ),
                    contentDescription = stringResource(R.string.no_internet_content_desc),
                    tint = foregroundColor
                )
                Text(
                    text = text,
                    color = foregroundColor,
                    fontSize = fontSizeSp.sp
                )
            }
        }
        Row {
            content()
        }
    }
}

@Preview
@Composable
fun PreviewNoInternet() {
    NetworkStateWrapper(
        backgroundColor = deepOrange003,
        foregroundColor = materialWhite,
        icon = R.drawable.ic_baseline_signal_wifi_off_24,
        text = stringResource(R.string.no_internet_error),
        heightDp = 45,
        fontSizeSp = 20
    ) {

    }
}