package com.aa.ui.screens.diagnosis_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DiagnosisCard(
    finalDiagnosis: String,
    suggestedTreatment: String,
    causeData: String,
    percentage: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFF8865), Color(0xFFFF3A00))
                )
            )
            .padding(16.dp)
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            Row {
                Text(
                    text = "Diagnosis :",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = Color.White
                    ),
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = finalDiagnosis,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(
                    text = "Cause :",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = Color.White
                    ),
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = causeData,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(
                    text = "Treatment :",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = Color.White
                    ),
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = suggestedTreatment,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("Percentage of confidence : $percentage%", style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight(700),
                color = Color.White
            ), modifier = Modifier.padding(8.dp))
        }
    }
}


@Preview
@Composable
fun PreviewDiagnosisCard() {
    DiagnosisCard(
        finalDiagnosis = "Anemia",
        suggestedTreatment = "Iron supplements, dietary changes to include iron-rich foods.",
        causeData = "Iron deficiency due to the increased demand for iron during pregnancy.",
        percentage = "100"
    )
}