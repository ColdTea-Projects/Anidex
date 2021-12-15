package de.coldtea.anidex.base.ui.viewitems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants.IterateForever
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

val loadingAnimationStack = listOf(
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_YmKbXU.json",
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_g7ve4rc8.json",
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_pdiwfsem.json",
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_v66fdky5.json",
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_j7miwfxd.json",
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_7maftaja.json",
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_d3mnuzm6.json",
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_yi6gwkwu.json",
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_gpunatuf.json",
    "https://assets9.lottiefiles.com/animated_stickers/lf_tgs_cjf0csuw.json"
)

@Composable
fun FullScreenLoader() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val url = remember {
            loadingAnimationStack.random()
        }

        val composition by rememberLottieComposition(LottieCompositionSpec.Url(url))

        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = IterateForever
        )

        LottieAnimation(
            composition = composition,
            progress = progress
        )
        CircularProgressIndicator(
            modifier = Modifier.size(30.dp),
            color = MaterialTheme.colors.primary
        )
    }
}