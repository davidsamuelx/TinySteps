package com.aa.ui.screens.phase_1.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.ui.theme.PrimaryColor
import com.aa.ui.theme.SecondaryColor
import com.aa.viewmodels.splash.SplashUiState
import com.aa.viewmodels.splash.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel =hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    SplashContent(navController = navController,
                state=state
        )
}

@Composable
private fun SplashContent(
        navController: NavController,
        state: SplashUiState
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
        if (state.isLogged){
            navController.navigate(TinyStepsDestination.Home)
        }else {
            navController.navigate(TinyStepsDestination.IntroScreen)
        }
    }
    Box(
        modifier= Modifier
            .fillMaxSize()
            .background(background)

    ){

    }
}
