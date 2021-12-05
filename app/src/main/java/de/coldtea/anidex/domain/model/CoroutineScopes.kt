package de.coldtea.anidex.domain.model

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import timber.log.Timber

val ioCoroutineScope
    get() = CoroutineScope(Dispatchers.IO + CoroutineExceptionHandler { _, t ->
        Timber.d("Anidex --> ioCoroutineScope crashed: $t")
    })

val mainCoroutineScope
    get() = CoroutineScope(Dispatchers.Main + CoroutineExceptionHandler { _, t ->
        Timber.d("Anidex --> ioCoroutineScope crashed: $t")
    })