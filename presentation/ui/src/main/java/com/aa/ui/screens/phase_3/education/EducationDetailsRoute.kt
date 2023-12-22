package com.aa.ui.screens.phase_3.education

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.viewmodels.education.EducationDetailsArgs

private const val ROUTE = TinyStepsDestination.EducationScreenDetails
fun NavGraphBuilder.educationDetailsRoute(navController: NavController){
    composable(
        route="$ROUTE/{${EducationDetailsArgs.ID_ARG}}",
        arguments= listOf(
            navArgument(EducationDetailsArgs.ID_ARG){
            type= NavType.IntType
            }
        )
    ){
        EducationDetailsScreen(navController = navController)
    }
}
fun NavController.navigateToEducationDetailsScreen(id:Int){
    navigate("${ROUTE}/$id")

}