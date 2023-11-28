package com.aa.ui.screens.phase_1.ai_state_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectionCard(
    modifier: Modifier = Modifier,
    iconRes : Int,
    numberRes : Int,
    text : String
) {
    Box(
        modifier = modifier
            .size(344.dp, 180.dp)
            .background(
                Brush.horizontalGradient(listOf(Color(0Xffff8865), Color(0Xffff3a00))),
                shape = RoundedCornerShape(16.dp)
            )
    ){
        Column (modifier = Modifier.fillMaxSize()){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(42.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                ){
                    Image(painter = painterResource(id = iconRes),
                        contentDescription = "diagnosis",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(28.dp)
                    )
                }
                Image(
                    painter = painterResource(id = numberRes),
                    contentDescription = "number 1",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(top = 16.dp , end = 16.dp)
                )
            }
            Spacer(Modifier.weight(1f))
            Text(text = text,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF)
                ),
                modifier = Modifier.padding(bottom =16.dp, start = 16.dp)

            )

        }

    }
}