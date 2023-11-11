package com.aa.ui.screens.discover_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DiscoverCard(
    modifier: Modifier = Modifier,
    icon : Int,
    text : String,
    color: Color,
    onCardClick : () -> Unit
) {
    Box (modifier = modifier
        .clickable { onCardClick() }
        .width(165.dp)
        .height(180.dp)
        .clip(RoundedCornerShape(20.dp))
        .background(color = color)
        ) {
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                IconCard(icon = icon)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = text,style = TextStyle(
                    fontSize = 17.97.sp,
                    lineHeight = 25.67.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF040415),

                    )
                )
            }
        }

}


@Composable
fun IconCard(
    modifier: Modifier = Modifier,
    icon: Int
){
    Box (
        modifier
            .width(32.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)){
        Column(modifier = modifier.fillMaxSize(),verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = icon), contentDescription = "Icon",modifier = Modifier.size(24.dp))
        }

    }

}


@Preview
@Composable
fun DiscoverCardPreview() {
    DiscoverCard(
        icon = com.aa.viewmodels.R.drawable.nutrition_icon,
        text = "Nutrition",
        color = Color(0xFFFCDCD3)
    ){}
}