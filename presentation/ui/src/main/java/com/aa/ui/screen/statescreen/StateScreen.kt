package com.aa.ui.screen.statescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.aa.ui.R
import com.aa.ui.screen.statescreen.composable.AppBarState
import com.aa.ui.screen.statescreen.composable.StateCard
import com.aa.ui.screens.home_screen.navigateToHomeScreen

@Composable
fun StateScreen(
navController: NavController
){
StateContent(
onClickPregnancy = navController::navigateToHomeScreen
)
}
@Composable
private fun StateContent(
onClickPregnancy:()->Unit,


){
        Column(
                modifier = Modifier.fillMaxSize()

        ) {
                AppBarState( titleAppBar = "Phase selection")
                StateCard(
                        painterResource(id = R.drawable.phasepregnancry),
                        "Pregnancy",
                        painterResource(id = R.drawable.one),
                        onClickPregnancy

                )
                StateCard(
                        painterResource(id = R.drawable.phaseinfants),
                        "Care for infants (0-3 years)",
                        painterResource(id = R.drawable.two),
                        onClick = {}
                )
                StateCard(
                        painterResource(id = R.drawable.phasekids),
                        "Care for child (3-6 years)",
                        painterResource(id = R.drawable.three),
                        onClick = {}

                )

        }


}
