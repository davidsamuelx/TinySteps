package com.aa.ui.screens.phase_1.home_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeHeader() {
    Column(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFF8865), Color(0xFFFF3A00))
                )
            ).padding(horizontal = 24.dp)
    ) {
        Text(text = "Hi, Mommy 👋🏻",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(500),
                color = Color.White,)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Let's share the pregnancy journey!",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(400),
                color = Color.White,)
        )

    }
}


@Preview
@Composable
fun HomeHeaderPreview() {
    HomeHeader()
}