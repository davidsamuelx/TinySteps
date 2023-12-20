package com.aa.ui.screens.phase_3.difference_game.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
    correctAnswer: Int,
    answer: Int,
    isClicked: Boolean,
    isAnyCardClicked: Boolean,
    onSelectedAnswer: (answerSelected: Int, isCorrect: Boolean) -> Unit,
    choices: List<Int>,
) {
    val isCorrectAnswer = correctAnswer == answer
    val durationMillis = 500

    val cardBackgroundState by animateColorAsState(
        targetValue = when {
            !isClicked -> Color(0xFFBBE5FA)
            isCorrectAnswer && isClicked  -> Color(0xFF31D14B)
            else -> Color(0xFFDF4B4B)
        }, animationSpec = tween(durationMillis = durationMillis), label = ""
    )
    choices.forEach {choice->
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(62.dp)
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .let { if (!isAnyCardClicked) it.clickable { onSelectedAnswer(choice, isCorrectAnswer) } else it }
                .padding(2.dp),
            border = BorderStroke(3.dp, cardBackgroundState)
        ) {
            Text(
                text = choice.toString(),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(400),
                    color = Color.Black,
                ),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }
    }
}


