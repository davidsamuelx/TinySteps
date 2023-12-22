package com.aa.ui.screens.phase_3.specialcase

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.phase_3.specialcase.KidsSpecialCaseDetailsArgs

private const val ROUTE = TinyStepsDestination.KidsSpecialCaseDetailsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.kidsSpecialCaseDetailsRoute(navController: NavController){
    composable(
        route = "$ROUTE/{${KidsSpecialCaseDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(KidsSpecialCaseDetailsArgs.ID_ARG){NavType.IntType}
        )
    ){ KidsSpecialCaseDetailsScreen(navController = navController) }
}


fun NavController.navigateToKidsSpecialCaseDetails(id: Int){
    navigate("${ROUTE}/${id}")
}
