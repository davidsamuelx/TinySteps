package com.aa.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.aa.ui.screens.badhabit.badHabitDetailRoute
import com.aa.ui.screens.badhabit.badHabitRoute
import com.aa.ui.screens.details_screen.babyDetailsRoute
import com.aa.ui.screens.discover_screen.discoverScreen
import com.aa.ui.screens.exercise.exerciseDetailsRoute
import com.aa.ui.screens.exercise.exerciseRoute
import com.aa.ui.screens.home_screen.homeScreen
import com.aa.ui.screens.infant_home_screen.infantHomeScreen
import com.aa.ui.screens.infants_badhabits.infantsBadHabitDetailRoute
import com.aa.ui.screens.infants_badhabits.infantsBadHabitRoute
import com.aa.ui.screens.infants_search.food.infantFoodDetailsRoute
import com.aa.ui.screens.infants_search.food.infantsFoodRoute
import com.aa.ui.screens.infants_search.infants_specialcase.infantsSpecialCaseDetailsRoute
import com.aa.ui.screens.infants_search.infants_specialcase.infantsSpecialCaseRoute
import com.aa.ui.screens.search.food.foodDetailsRoute
import com.aa.ui.screens.search.food.foodRoute
import com.aa.ui.screens.search.music.musicDetailsRoute
import com.aa.ui.screens.search.music.musicRoute
import com.aa.ui.screens.search.sleep.sleepDetailRoute
import com.aa.ui.screens.search.sleep.sleepPositionRoute
import com.aa.ui.screens.search.specialcase.specialCaseDetailsRoute
import com.aa.ui.screens.search.specialcase.specialCaseRoute

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun TinyStepsGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = TinyStepsDestination.Home){
        badHabitRoute(navController)
        specialCaseRoute(navController)
        foodRoute(navController)
        sleepPositionRoute(navController)
        musicRoute(navController)
        foodDetailsRoute(navController)
        badHabitDetailRoute(navController)
        musicDetailsRoute(navController)
        sleepDetailRoute(navController)
        specialCaseDetailsRoute(navController)
        exerciseRoute(navController)
        exerciseDetailsRoute(navController)
        babyDetailsRoute(navController)
        discoverScreen(navController)
        homeScreen(navController)
        infantHomeScreen(navController)
        infantsFoodRoute(navController)
        infantFoodDetailsRoute(navController)
        infantsBadHabitRoute(navController)
        infantsBadHabitDetailRoute(navController)
        infantsSpecialCaseRoute(navController)
        infantsSpecialCaseDetailsRoute(navController)
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
    const val MusicDetailsScreen = "musicDetailsScreen"
    const val SleepPositionByIdDetailsScreen = "sleepPositionByIdDetailsScreen"
    const val SpecialCaseDetailsScreen = "specialCaseDetailsScreen"
    const val ExerciseScreen = "exerciseScreen"
    const val ExerciseDetailsScreen = "exerciseDetailsScreen"
    const val InfantHomeScreen = "infantHomeScreen"
    const val InfantFoodScreen = "infantsFoodScreen"
    const val InfantsFoodDetails = "infantsFoodDetailsScreen"
    const val InfantsBadHabitScreen = "infantsBadHabitScreen"
    const val InfantsBadHabitDetailScreen = "infantsBadHabitDetailsScreen"
    const val InfantsSpecialCaseScreen = "infantsSpecialCaseScreen"
    const val InfantsSpecialCaseDetailsScreen = "infantsSpecialCaseDetailsScreen"

}