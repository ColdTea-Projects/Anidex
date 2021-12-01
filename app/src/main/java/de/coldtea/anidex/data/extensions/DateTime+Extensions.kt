package de.coldtea.anidex.data.extensions

import java.util.Calendar

val nowInMiliseconds: Long
    get() = Calendar.getInstance().timeInMillis