package com.aa.ui.screens.phase_2.infants_search.products

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.details.DetailsContent
import com.aa.viewmodels.infants_products.InfantsProductsDetailsUiState
import com.aa.viewmodels.infants_products.InfantsProductsDetailsViewModel


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun InfantsProductsDetailsScreen(
    navController: NavController,
    viewModel: InfantsProductsDetailsViewModel = hiltViewModel(),
){
    val state by viewModel.state.collectAsState()

    InfantsProductsDetailsContent(
        state = state,
        navController = navController
    )

}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun InfantsProductsDetailsContent(
    state: InfantsProductsDetailsUiState,
    navController: NavController,
){
    DetailsContent(
        navController = navController,
        imageUrl = state.infantsProducts.pathImg!!,
        titleName = state.infantsProducts.nameProductEN!!,
        details = state.infantsProducts.detailsEN!!,
        doctorName = state.infantsProducts.doctorName!!,
        doctorLocation = state.infantsProducts.doctorLocation!!,
        doctorNumber = state.infantsProducts.phoneDoctor!!,
        problemName ="",
        problemSolve = "",
    )
}