package com.aa.ui.screens.diagnosis_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.diagnosis_screen.composables.CustomTextField
import com.aa.ui.screens.diagnosis_screen.composables.DiagnosisCard
import com.aa.ui.screens.phase_1.details_screen.composables.CustomHeader
import com.aa.viewmodels.diagnosis_screen.DiagnosisUiState
import com.aa.viewmodels.diagnosis_screen.DiagnosisViewModel

@Composable
fun DiagnosisScreen(
    navController: NavController,
    viewModel: DiagnosisViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    DiagnosisScreenContent(
        state = state,
        onBackClicked = navController::backToDiagnosisScreen,
        onDiagnosisClicked = viewModel::onDiagnosisClicked,
        onFirstSymptomChange = viewModel::onFirstSymptomChange,
        onSecondSymptomChange = viewModel::onSecondSymptomChange,
        onThirdSymptomChange = viewModel::onThirdSymptomChange,
        onFourthSymptomChange = viewModel::onFourthSymptomChange,
        onFifthSymptomChange = viewModel::onFifthSymptomChange,
    )

}


@Composable
private fun DiagnosisScreenContent(
    state: DiagnosisUiState,
    onBackClicked: () -> Unit,
    onDiagnosisClicked: () -> Unit,
    onFirstSymptomChange: (CharSequence) -> Unit,
    onSecondSymptomChange: (CharSequence) -> Unit,
    onThirdSymptomChange: (CharSequence) -> Unit,
    onFourthSymptomChange: (CharSequence) -> Unit,
    onFifthSymptomChange: (CharSequence) -> Unit,
) {
    val visibleFields = remember { mutableIntStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CustomHeader(onBackClicked = { onBackClicked() }, text = "Diagnosis")
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CustomTextField(
                query = state.firstSymptom, onQueryChange = onFirstSymptomChange,
                hint = "1",
                modifier = Modifier.weight(1f),
                plusClick = {
                    if (visibleFields.intValue < 5) {
                        visibleFields.intValue += 1
                    }
                },
                plusVisibility = visibleFields.intValue < 5,
            )
            if (visibleFields.intValue >= 2
            ) {
                CustomTextField(
                    query = state.secondSymptom, onQueryChange = onSecondSymptomChange,
                    hint = "2",
                    modifier = Modifier.weight(1f),
                    plusVisibility = false
                )
            }
        }
        AnimatedVisibility(visibleFields.intValue >= 3) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CustomTextField(
                    query = state.thirdSymptom, onQueryChange = onThirdSymptomChange,
                    hint = "3",
                    modifier = Modifier.weight(1f),
                    plusVisibility = false
                )
                if (visibleFields.intValue >= 4) {
                    CustomTextField(
                        query = state.fourthSymptom, onQueryChange = onFourthSymptomChange,
                        hint = "4",
                        modifier = Modifier.weight(1f),
                        plusVisibility = false
                    )
                }
            }
        }
        AnimatedVisibility(visibleFields.intValue >= 5) {
            CustomTextField(
                query = state.fifthSymptom,
                onQueryChange = onFifthSymptomChange,
                hint = "5",
                plusVisibility = false
            )
        }
        Button(
            onClick = { onDiagnosisClicked() },
            colors = ButtonDefaults.buttonColors(Color(0Xffff3a00)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Diagnosis",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                ),
            )
        }
        AnimatedVisibility(state.diagnosis.isNotEmpty()) {
            DiagnosisCard(
                finalDiagnosis = state.diagnosis,
                suggestedTreatment = state.treatment.toString(),
                causeData = state.cause,
                percentage = state.percentage,
                modifier = Modifier.padding(16.dp)
            )
        }


    }


}


@Preview
@Composable
fun PreviewDiagnosisScreen() {
    DiagnosisScreenContent(DiagnosisUiState(), {}, {}, {}, {}, {}, {}, {})
}