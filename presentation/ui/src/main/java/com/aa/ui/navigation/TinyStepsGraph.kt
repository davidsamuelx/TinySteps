package com.aa.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun TinyStepsGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = TinyStepsDestination.Start){

    }
}


object TinyStepsDestination {
    const val Start = ""
}