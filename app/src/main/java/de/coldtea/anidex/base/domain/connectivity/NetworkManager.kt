package de.coldtea.anidex.base.domain.connectivity

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect

object NetworkManager {
    /**
     * Network utility to get current state of internet connection
     */
    val Context.currentConnectivityState: ConnectionState
        get() {
            val connectivityManager =
                getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return getCurrentConnectivityState(connectivityManager)
        }

    private fun getCurrentConnectivityState(
        connectivityManager: ConnectivityManager
    ): ConnectionState {
        val connected = connectivityManager.allNetworks.any { network ->
            connectivityManager.getNetworkCapabilities(network)
                ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                ?: false
        }

        return if (connected) ConnectionState.Online else ConnectionState.Offline
    }

    fun NetworkCallback(callback: (ConnectionState) -> Unit): ConnectivityManager.NetworkCallback {
        return object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                callback(ConnectionState.Online)
            }

            override fun onLost(network: Network) {
                callback(ConnectionState.Offline)
            }
        }
    }

    @ExperimentalCoroutinesApi
    fun Context.observeConnectivityAsFlow() = callbackFlow {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val callback = NetworkCallback { connectionState -> trySend(connectionState) }

        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(networkRequest, callback)

        // Set current state
        val currentState = getCurrentConnectivityState(connectivityManager)
        trySend(currentState)

        // Remove callback when not used
        awaitClose {
            // Remove listeners
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }

    @ExperimentalCoroutinesApi
    @Composable
    fun connectivityState(): State<ConnectionState> {
        val context = LocalContext.current

        // Creates a State<ConnectionState> with current connectivity state as initial value
        return produceState(initialValue = context.currentConnectivityState) {
            // In a coroutine, can make suspend calls
            context.observeConnectivityAsFlow().collect {
                value = it
            }
        }
    }
}