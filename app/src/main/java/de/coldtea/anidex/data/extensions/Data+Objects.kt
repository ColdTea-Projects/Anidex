package de.coldtea.anidex.data

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@ExperimentalSerializationApi
val json = Json{
    ignoreUnknownKeys = true
    explicitNulls = false
    isLenient = true
}