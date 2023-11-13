package com.aa.ui.screens.search.specialcase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.base.viewmodels.cateories.specialcase.SpecialCaseDetailsArgs
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.SpecialCaseDetailsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.specialCaseDetailsRoute(navController: NavController){
    composable(
        route = "$ROUTE/{${SpecialCaseDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(SpecialCaseDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ SpecialCaseDetailsScreen(navController = navController) }
}


fun NavController.navigateToSpecialCaseDetails(id: Int){
    navigate("${ROUTE}/${id}")
}
