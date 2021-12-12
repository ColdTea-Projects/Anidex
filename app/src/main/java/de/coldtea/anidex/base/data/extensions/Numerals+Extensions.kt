package de.coldtea.anidex.base.data.extensions

fun Int?.orZero() = this?:0

fun Double?.orZero() = this?:0.0

fun Int?.orInvalidId() = this?:-1