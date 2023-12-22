package com.aa.ui.screens.phase_1.statescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.aa.ui.R
import com.aa.ui.screens.phase_1.home_screen.navigateToHomeScreen
import com.aa.ui.screens.phase_1.statescreen.composable.AppBarState
import com.aa.ui.screens.phase_1.statescreen.composable.StateCard
import com.aa.ui.screens.phase_2.infant_home_screen.navigateToInfantHomeScreen
import com.aa.ui.screens.phase_3.home_screen.navigateToHomeKidsScreen

@Composable
fun StateScreen(
navController: NavController
){
StateContent(
onClickPregnancy = navController::navigateToHomeScreen,
onClickPhase2 = navController::navigateToInfantHomeScreen,
onClickPhase3 = navController::navigateToHomeKidsScreen
)
}
@Composable
private fun StateContent(
onClickPregnancy:()->Unit,
onClickPhase2 :()->Unit = {},
onClickPhase3: ()->Unit = {}

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
                        onClick = {
                                onClickPhase2()
                        }
                )
                StateCard(
                        painterResource(id = R.drawable.phasekids),
                        "Care for child (3-6 years)",
                        painterResource(id = R.drawable.three),
                        onClick = {onClickPhase3()}

                )

        }


}
