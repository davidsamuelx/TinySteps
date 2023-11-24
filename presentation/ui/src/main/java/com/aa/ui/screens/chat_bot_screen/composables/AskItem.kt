package com.aa.ui.screens.chat_bot_screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AskItem(
    text: String,
    modifier: Modifier = Modifier,
) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.CenterEnd)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        Brush.horizontalGradient(listOf(Color(0Xffff8865), Color(0Xffff3a00))),
                        shape = RoundedCornerShape(
                            topStart = 24.dp,
                            bottomEnd = 24.dp,
                            bottomStart = 24.dp
                        )
                    )
            ) {
                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight(700),
                        color = Color.White
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

}



@Preview
@Composable
fun AskItemPreview() {
    AskItem(text ="What is the best programming language?")
}