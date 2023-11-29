package com.aa.ui.screens.phase_2.infants_search.food

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.infants_food.InfantsFoodDetailsArgs

private const val ROUTE = TinyStepsDestination.InfantsFoodDetails

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantFoodDetailsRoute(navController: NavHostController){
    composable(
        route = "$ROUTE/{${InfantsFoodDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(InfantsFoodDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ InfantsFoodDetailsScreen(navController = navController) }
}

fun NavController.navigateToInfantFoodDetails(id: Int){
    navigate("$ROUTE/${id}")
}


