package com.aa.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.aa.ui.screens.badhabit.badHabitDetailRoute
import com.aa.ui.screens.badhabit.badHabitRoute
import com.aa.ui.screens.search.food.foodDetailsRoute
import com.aa.ui.screens.search.food.foodRoute
import com.aa.ui.screens.search.music.musicRoute
import com.aa.ui.screens.search.sleep.sleepPositionRoute
import com.aa.ui.screens.search.specialcase.specialCaseRoute
import com.aa.ui.screens.details_screen.babyDetailsRoute
import com.aa.ui.screens.discover_screen.discoverScreen
import com.aa.ui.screens.home_screen.homeScreen

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun TinyStepsGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = TinyStepsDestination.Home){
        homeScreen(navController = navController )
        babyDetailsRoute(navController = navController)
        discoverScreen(navController = navController)
        badHabitRoute(navController)
        specialCaseRoute(navController)
        foodRoute(navController)
        sleepPositionRoute(navController)
        musicRoute(navController)
        foodDetailsRoute(navController)
        badHabitDetailRoute(navController)
    }
}


object TinyStepsDestination {
    const val Start = ""
    const val FoodDetails = "foodDetailsScreen"
    const val FoodScreen = "foodScreen"
    const val BadHabitScreen = "badHabitScreen"
    const val BadHabitDetailScreen = "badHabitDetailsScreen"
    const val MusicScreen = "musicScreen"
    const val SleepScreen = "sleepScreen"
    const val SpecialCaseScreen = "specialCaseScreen"
    const val Home = "homeScreen"
    const val BabyDetails = "babyDetails"
    const val Discover = "discoverScreen"
}