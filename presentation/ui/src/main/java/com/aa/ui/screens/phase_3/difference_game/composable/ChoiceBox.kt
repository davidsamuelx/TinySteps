package com.aa.ui.screens.phase_3.difference_game.composable

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun ChoiceBox(
    modifier: Modifier = Modifier,
    choices: List<String>,
    onChoiceSelected: (String) -> Unit
) {
    Log.d("ChoiceBox", "Choices: $choices")
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        choices.forEach { choice ->
            ChoiceItem(
                text = choice,
                onChoiceSelected = { onChoiceSelected(choice) }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun ChoiceItem(
    text: String,
    onChoiceSelected: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(56.dp)
            .clip(CircleShape)
            .border(
                border = BorderStroke(2.dp, Color(0xFFB7B7BB)),
                shape = CircleShape
            )
            .background(Color.White)
            .clickable { onChoiceSelected() }
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(400),
                color = Color.Black,
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
        )
    }
}
//@Preview
//@Composable
//fun PreviewBox(){
//    ChoiceBox(modifier = Modifier,"3")
//}