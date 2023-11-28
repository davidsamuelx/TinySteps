package com.aa.ui.screens.phase_1.home_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
fun CalendarItem(
    modifier: Modifier = Modifier,
    number: Int,
    isClicked: Boolean,
    onClickItem: (Int) -> Unit,
) {
    val borderColor = if (isClicked) Color(0xFFFF8865) else Color(0xFFEAECF0)
    val numberColor = if (isClicked) Color(0xFFFF8865) else Color(0xFF040415)
    val periodColor = if (isClicked) Color(0xFFFF8865) else Color(0xFFCDCDD0)
    val borderWidth = if (isClicked) 2.dp else 1.dp

    Box(
        modifier = modifier
            .clickable(onClick = {
                onClickItem(number)
            })
            .size(52.dp, 64.dp)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(size = 16.dp)
            )
            .background(color = Color.White, shape = RoundedCornerShape(size = 16.dp))
            .padding(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = number.toString(),
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = numberColor,
                )
            )
            Text(
                text = "WEEK",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(700),
                    color = periodColor,
                    textAlign = TextAlign.Center,
                    letterSpacing = 1.sp,
                )
            )
        }
    }
}
@Preview
@Composable
fun CalendarItemPreview() {
    CalendarItem(
        number = 0,
        onClickItem = {},
        isClicked = true
    )
}