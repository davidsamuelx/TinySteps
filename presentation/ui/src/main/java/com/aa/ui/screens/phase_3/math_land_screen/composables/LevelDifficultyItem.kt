package com.aa.ui.screens.phase_3.math_land_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LevelDifficultyItem(
    modifier: Modifier = Modifier,
    level: String,
    isClicked: Boolean,
    onClickItem: (String) -> Unit,
) {
    val textColor = if (isClicked) Color(0xFFFFFFFF) else Color(0xFF040415)
    val bgColor = if (isClicked) Color(0xFFF15223) else Color(0xFFEAECF0)

    Box(
        modifier = modifier
            .clickable(onClick = {
                onClickItem(level)
            })
            .size(width = 104.dp, height = 34.dp)
            .background(color = bgColor, shape = RoundedCornerShape(size = 16.dp))
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = level,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = textColor,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Preview
@Composable
fun LevelDifficultyItemPreview() {
    LevelDifficultyItem(level = "Easy", isClicked = true, onClickItem = {})
}