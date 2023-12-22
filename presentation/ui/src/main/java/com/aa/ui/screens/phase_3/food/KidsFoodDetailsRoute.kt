package com.aa.ui.screens.phase_3.food

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.phase_3.kids_food.KidsFoodDetailsArgs

private const val ROUTE = TinyStepsDestination.KidsFoodDetailsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.kidsFoodDetailsRoute(navController: NavHostController){
    composable(
        route = "$ROUTE/{${KidsFoodDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(KidsFoodDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ KidsFoodDetailsScreen(navController = navController) }
}

fun NavController.navigateToKidsFoodDetails(id: Int){
    navigate("$ROUTE/${id}")
}


