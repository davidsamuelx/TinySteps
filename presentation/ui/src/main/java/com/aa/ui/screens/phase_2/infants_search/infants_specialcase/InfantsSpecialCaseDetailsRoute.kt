package com.aa.ui.screens.phase_2.infants_search.infants_specialcase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.infants_specialcase.InfantsSpecialCaseDetailsArgs

private const val ROUTE = TinyStepsDestination.InfantsSpecialCaseDetailsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.infantsSpecialCaseDetailsRoute(navController: NavController){
    composable(
        route = "$ROUTE/{${InfantsSpecialCaseDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(InfantsSpecialCaseDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ InfantsSpecialCaseDetailsScreen(navController = navController) }
}


fun NavController.navigateToInfantsSpecialCaseDetails(id: Int){
    navigate("${ROUTE}/${id}")
}
