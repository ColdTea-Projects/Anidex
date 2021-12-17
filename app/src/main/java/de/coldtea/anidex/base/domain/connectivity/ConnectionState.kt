package de.coldtea.anidex.base.domain.connectivity

sealed class ConnectionState {
    object Online : ConnectionState()
    object Offline : ConnectionState()
}