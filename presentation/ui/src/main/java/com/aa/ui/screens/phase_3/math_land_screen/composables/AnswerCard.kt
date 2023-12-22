package com.aa.ui.screens.phase_3.math_land_screen.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AnswerCard(
    modifier: Modifier = Modifier,
    correctAnswer: String,
    images: List<String>,
    answer: String,
    isClicked: Boolean,
    isAnyCardClicked: Boolean,
    onSelectedAnswer: (answerSelected: String, isCorrect: Boolean) -> Unit,
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


    images.forEach { image ->
        Card(
            modifier = modifier
                .size(width = 167.dp, height = 102.dp)
                .clip(RoundedCornerShape(16.dp))
                .let { if (!isAnyCardClicked) it.clickable { onSelectedAnswer(image, isCorrectAnswer) } else it }
                .padding(2.dp),
            border = BorderStroke(3.dp, cardBackgroundState)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Image(
                    painter = rememberAsyncImagePainter(image),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }

}

//@Preview
//@Composable
//fun AnswerCardPreview() {
//    AnswerCard(
//        correctAnswer = "1",
//        image = "https://tiny-steps.help/storage/uploads/path_img/YKDkmUTFdJgAKCjV7g69wEZ2dFB5lr0SPy6Bx2vx.jpg",
//        answer = "1",
//        isClicked = true,
//        onSelectedAnswer = {}
//    )
//}