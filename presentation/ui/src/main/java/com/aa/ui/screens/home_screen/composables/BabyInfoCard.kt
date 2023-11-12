package com.aa.ui.screens.home_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.ui.R
import com.aa.viewmodels.home_screen.HomeUiState

@Composable
fun BabyInfoCard(
    state : HomeUiState,
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit
) {
        Box(
            modifier = modifier
                .size(344.dp, 158.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFF8865), Color(0xFFFF3A00))
                    )
                )
                .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp),
        ) {
            Column(Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.star_icon),
                    contentDescription = "icon"
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Your Baby", style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color.White,
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = state.babyInfo,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color.White,
                    ),
                    maxLines = 2,
                )
                Button(
                    onClick = { onButtonClicked() },
                    modifier = Modifier
                        .wrapContentSize()
                        .weight(1f)
                        .align(Alignment.End),
                    colors = ButtonDefaults.buttonColors(
                        Color.White
                    )
                ) {
                    Text(
                        text = "More", style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF040415),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }

        }
    }