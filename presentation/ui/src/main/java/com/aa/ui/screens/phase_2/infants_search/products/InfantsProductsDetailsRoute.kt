package com.aa.ui.screens.phase_2.infants_search.products

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.infants_products.InfantsProductsArgs

private const val ROUTE = TinyStepsDestination.InfantsProductsDetailsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantProductsDetailsRoute(navController: NavHostController){
    composable(
        route = "$ROUTE/{${InfantsProductsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(InfantsProductsArgs.ID_ARG){NavType.IntType}
        )
    ){ InfantsProductsDetailsScreen(navController = navController) }
}

fun NavController.navigateToInfantProductsDetails(id: Int){
    navigate("$ROUTE/${id}")
}


