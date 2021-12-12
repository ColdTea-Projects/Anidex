package de.coldtea.anidex.base.data.extensions

import java.util.Calendar

val nowInMiliseconds: Long
    get() = Calendar.getInstance().timeInMillis