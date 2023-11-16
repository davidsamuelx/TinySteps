package com.aa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aa.ui.screen.IntroScreen.introScreen
import com.aa.ui.screen.signUp.signUp
import com.aa.ui.screen.signinscreen.signIn
import com.aa.ui.screen.splash.SplashScreen
import com.aa.ui.screen.statescreen.state
import com.aa.ui.screens.details_screen.babyDetailsRoute
import com.aa.ui.screens.discover_screen.discoverScreen
import com.aa.ui.screens.home_screen.homeScreen

@Composable
fun TinyStepsGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = TinyStepsDestination.SplashScreen) {
        composable(TinyStepsDestination.SplashScreen) { SplashScreen(navController = navController) }
        introScreen(navController)
        signIn(navController)
        signUp(navController)
        state(navController)
        homeScreen(navController = navController)
        babyDetailsRoute(navController = navController)
        discoverScreen(navController = navController)

    }
}

object TinyStepsDestination {
    const val Home = "homeScreen"
    const val BabyDetails = "babyDetails"
    const val Discover = "discoverScreen"
    const val Start = ""
    const val SplashScreen="splash"
    const val IntroScreen="Intro screen"
    const val SignIn="sign in"
    const val SignUp="sign up"
    const val StateScreen="stateScreen"

}