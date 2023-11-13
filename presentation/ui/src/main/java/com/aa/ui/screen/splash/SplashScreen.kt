package com.aa.ui.screen.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.ui.theme.PrimaryColor
import com.aa.ui.theme.SecondaryColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
) {
    SplashContent(navController = navController)
}

@Composable
private fun SplashContent(
        navController: NavController
) {
    val background= Brush.linearGradient(
        0.0f to PrimaryColor,
        500.0f to  SecondaryColor,
    )
    val scale = remember {
            Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate(TinyStepsDestination.IntroScreen)
    }
    Box(
        modifier= Modifier
            .fillMaxSize()
            .background(background)

    ){

    }
}
