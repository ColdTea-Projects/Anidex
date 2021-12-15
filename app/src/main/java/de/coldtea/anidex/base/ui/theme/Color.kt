package de.coldtea.anidex.base.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val deepOrange001 = Color(0xFFDD2C00)
val deepOrange002 = Color(0xFFFF6434)
val deepOrange003 = Color(0xFFA30000)

val gold001 = Color(0xFFFFC107)

val blueGray001 = Color(0xFF263238)
val blueGray002 = Color(0xFF4F5B62)
val blueGrayLight = Color(0xFFDEE6EB)
val blueGrayDark = Color(0xFF121314)

val cyan001 = Color(0xFF006064)
val cyan002 = Color(0xFF428e92)

val materialWhite = Color(0xFFEEE8F7)
val materialBlack = Color(0xFF000105)
val materialDarkG = Color(0xFF000105)

val materialBlackT90 = Color(0xE6000000)

val LightColors = lightColors(
    primary = deepOrange001,
    primaryVariant = deepOrange002,
    secondary = blueGray001,
    secondaryVariant = blueGray002,
    background = blueGrayLight,
    surface = materialWhite,
    error = deepOrange003
)

val DarkColors = darkColors(
    primary = deepOrange001,
    primaryVariant = deepOrange002,
    secondary = cyan001,
    secondaryVariant = cyan002,
    background = blueGrayDark,
    surface = deepOrange003,
    error = deepOrange003
)