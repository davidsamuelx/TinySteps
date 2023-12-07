package com.aa.ui.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.aa.ui.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun Loading() {

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.loading_tiny)
    )
    LottieAnimation(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}