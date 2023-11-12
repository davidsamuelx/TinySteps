package com.aa.ui.screens.home_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.ui.R

@Composable
fun PregnancyProgressBar() {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFEAECF0),
                shape = RoundedCornerShape(size = 16.dp)
            )
            .height(72.dp)
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.Center
    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.time_circle),
                contentDescription = "Time Icon" ,
                alignment = Alignment.Center
            )
            Column {
                Text(text = "First trimester ❤‍",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF040415)
                    ),
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(text = "34 weeks to go!",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF9B9BA1)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = .3f,
            modifier = Modifier
                .height(4.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
            color =  Color(0xFFF15223),
        )

    }
}