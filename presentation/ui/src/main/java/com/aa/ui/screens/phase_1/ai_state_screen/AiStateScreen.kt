package com.aa.ui.screens.phase_1.ai_state_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aa.ui.R
import com.aa.ui.screens.chat_bot_screen.navigateToChatBotScreen
import com.aa.ui.screens.phase_1.ai_state_screen.composables.SelectionCard


@Composable
fun AiStateScreen(
    navController: NavController,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Text(
            text = "AI Selection",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF040415),
            ),
            modifier = Modifier.padding(16.dp)
        )
        SelectionCard(
            iconRes = R.drawable.diagnosis_bot,
            numberRes = R.drawable.number_1,
            text = "Diagnosis",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)

        )
        SelectionCard(
            iconRes = R.drawable.chat_bot,
            numberRes = R.drawable.number_2,
            text = "Chat",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable { navController.navigateToChatBotScreen() }
        )


    }


}


@Preview
@Composable
fun AiStateScreenPreview() {
    AiStateScreen(navController = NavController(LocalContext.current))
}