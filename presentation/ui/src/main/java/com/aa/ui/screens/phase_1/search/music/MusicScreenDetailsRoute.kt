package com.aa.ui.screens.phase_1.search.music

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aa.viewmodels.music.MusicDetailsArgs
import com.aa.ui.navigation.TinyStepsDestination

private const val ROUTE = TinyStepsDestination.MusicDetailsScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.musicDetailsRoute(navController: NavController){
    composable(
        "$ROUTE/{${MusicDetailsArgs.ID_ARG}}",
        arguments = listOf(
            navArgument(MusicDetailsArgs.ID_ARG){
                type = NavType.IntType
            }
        )
    ){ MusicDetailsScreen(navController = navController) }
}


fun NavController.navigateToMusicDetails(id: Int){
    navigate("$ROUTE/$id")
}
