package com.aa.ui.screens.badhabit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.base.viewmodels.cateories.badhabit.BadHabitDetailsViewModel
import com.aa.base.viewmodels.cateories.badhabit.BadHabitViewModel
import com.aa.ui.screens.details.DetailsContent

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun BadHabitDetailsScreen(
    navController: NavController,
    viewModel: BadHabitDetailsViewModel = hiltViewModel(),
){

    BadHabitDetailsContent(
        navController,
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun BadHabitDetailsContent(
    navController: NavController,
){
    DetailsContent(
        navController = navController,
        imageUrl = ""
    )
}