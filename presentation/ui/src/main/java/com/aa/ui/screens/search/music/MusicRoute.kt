package com.aa.ui.screens.search.music

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aa.ui.navigation.TinyStepsDestination


private const val ROUTE = TinyStepsDestination.MusicScreen

@RequiresApi(Build.VERSION_CODES.Q)
fun NavGraphBuilder.musicRoute(navController: NavController){
    composable(ROUTE){ MusicScreen(navController = navController) }
}