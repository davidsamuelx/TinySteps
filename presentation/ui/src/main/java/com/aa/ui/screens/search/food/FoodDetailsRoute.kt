package com.aa.ui.screens.search.food

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.base.viewmodels.cateories.food.FoodDetailsArgs
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.FoodDetails

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.foodDetailsRoute(navController: NavHostController){
    composable(
        route = "$ROUTE/{${FoodDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(FoodDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ FoodDetailsScreen(navController = navController) }
}

fun NavController.navigateToFoodDetails(id: Int){
    navigate("$ROUTE/${id}")
}


