package com.aa.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aa.ui.screens.chat_bot_screen.chatBotScreen
import com.aa.ui.screens.diagnosis_screen.diagnosisScreen
import com.aa.ui.screens.phase_1.IntroScreen.introScreen
import com.aa.ui.screens.phase_1.ai_state_screen.aiStateScreen
import com.aa.ui.screens.phase_1.badhabit.badHabitDetailRoute
import com.aa.ui.screens.phase_1.badhabit.badHabitRoute
import com.aa.ui.screens.phase_1.details_screen.babyDetailsRoute
import com.aa.ui.screens.phase_1.discover_screen.discoverScreen
import com.aa.ui.screens.phase_1.exercise.exerciseDetailsRoute
import com.aa.ui.screens.phase_1.exercise.exerciseRoute
import com.aa.ui.screens.phase_1.home_screen.homeScreen
import com.aa.ui.screens.phase_1.search.food.foodDetailsRoute
import com.aa.ui.screens.phase_1.search.food.foodRoute
import com.aa.ui.screens.phase_1.search.music.musicDetailsRoute
import com.aa.ui.screens.phase_1.search.music.musicRoute
import com.aa.ui.screens.phase_1.search.sleep.sleepDetailRoute
import com.aa.ui.screens.phase_1.search.sleep.sleepPositionRoute
import com.aa.ui.screens.phase_1.search.specialcase.specialCaseDetailsRoute
import com.aa.ui.screens.phase_1.search.specialcase.specialCaseRoute
import com.aa.ui.screens.phase_1.signUp.signUp
import com.aa.ui.screens.phase_1.signinscreen.signIn
import com.aa.ui.screens.phase_1.splash.SplashScreen
import com.aa.ui.screens.phase_1.statescreen.state
import com.aa.ui.screens.phase_2.infant_discover_screen.infantDiscoverRoute
import com.aa.ui.screens.phase_2.infant_exercise.infantExerciseDetailsRoute
import com.aa.ui.screens.phase_2.infant_exercise.infantExerciseRoute
import com.aa.ui.screens.phase_2.infant_home_screen.guidanceDetailsRoute
import com.aa.ui.screens.phase_2.infant_home_screen.infantHomeScreen
import com.aa.ui.screens.phase_2.infants_badhabits.infantsBadHabitDetailRoute
import com.aa.ui.screens.phase_2.infants_badhabits.infantsBadHabitRoute
import com.aa.ui.screens.phase_2.infants_search.food.infantFoodDetailsRoute
import com.aa.ui.screens.phase_2.infants_search.food.infantsFoodRoute
import com.aa.ui.screens.phase_2.infants_search.infants_specialcase.infantsSpecialCaseDetailsRoute
import com.aa.ui.screens.phase_2.infants_search.infants_specialcase.infantsSpecialCaseRoute
import com.aa.ui.screens.phase_2.infants_search.products.infantProductsDetailsRoute
import com.aa.ui.screens.phase_2.infants_search.products.infantsProductsRoute
import com.aa.ui.screens.phase_2.infants_search.sleep_hours.infantsSleepDetailRoute
import com.aa.ui.screens.phase_2.infants_search.sleep_hours.infantsSleepRoute
import com.aa.ui.screens.phase_2.relation_screen.relationDetailsRoute
import com.aa.ui.screens.phase_3.animal_sound_screen.animalSoundScreen
import com.aa.ui.screens.phase_3.difference_game.diffOfTwoImage
import com.aa.ui.screens.phase_3.education.educationDetailsRoute
import com.aa.ui.screens.phase_3.education.educationRoute
import com.aa.ui.screens.phase_3.math_land_screen.mathLandRoute

@RequiresApi(Build.VERSION_CODES.Q)
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
        guidanceDetailsRoute(navController)
         infantExerciseRoute(navController)
        infantExerciseDetailsRoute(navController)
        infantsProductsRoute(navController)
        infantProductsDetailsRoute(navController)
        infantsSleepRoute(navController)
        infantsSleepDetailRoute(navController)
        infantDiscoverRoute(navController)
        relationDetailsRoute(navController)
        aiStateScreen(navController)
        chatBotScreen(navController)
        educationRoute(navController)
        educationDetailsRoute(navController)
        diffOfTwoImage(navController)
        animalSoundScreen(navController)
        mathLandRoute(navController)
        diagnosisScreen(navController)
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
    const val SplashScreen="splash"
    const val IntroScreen="Intro screen"
    const val SignIn="sign in"
    const val SignUp="sign up"
    const val StateScreen="stateScreen"
    const val MusicDetailsScreen = "musicDetailsScreen"
    const val SleepPositionByIdDetailsScreen = "sleepPositionByIdDetailsScreen"
    const val SpecialCaseDetailsScreen = "specialCaseDetailsScreen"
    const val ExerciseScreen = "exerciseScreen"
    const val ExerciseDetailsScreen = "exerciseDetailsScreen"
    const val AiStateScreen = "aiStateScreen"
    const val ChatBotScreen = "chatBotScreen"
    const val InfantHomeScreen = "infantHomeScreen"
    const val InfantFoodScreen = "infantsFoodScreen"
    const val InfantsFoodDetails = "infantsFoodDetailsScreen"
    const val InfantsBadHabitScreen = "infantsBadHabitScreen"
    const val InfantsBadHabitDetailScreen = "infantsBadHabitDetailsScreen"
    const val InfantsSpecialCaseScreen = "infantsSpecialCaseScreen"
    const val InfantsSpecialCaseDetailsScreen = "infantsSpecialCaseDetailsScreen"
    const val InfantsProductsScreen = "infantsProductsScreen"
    const val InfantsProductsDetailsScreen = "infantsProductsDetailsScreen"
    const val InfantsSleepScreen = "infantsSleepScreen"
    const val InfantsSleepDetailsScreen = "infantsSleepDetailsScreen"
    const val GuidanceDetailsScreen = "guidanceDetailsScreen"
    const val InfantExerciseScreen = "infantsExerciseScreen"
    const val InfantExerciseDetailsScreen = "infantsExerciseDetailsScreen"
    const val InfantDiscoverScreen = "infantsDiscoverScreen"
    const val RelationDetailsScreen = "relationDetailsScreen"
    const val AnimalSoundScreen = "animalSoundScreen"
    const val MathLandScreen = "mathLandScreen"
    const val EducationScreen = "EducationScreen"
    const val EducationScreenDetails= "EducationScreenDetails"
    const val DiffOfImageScreen="DiffOfImageScreen"
    const val DiagnosisScreen = "diagnosisScreen"
}