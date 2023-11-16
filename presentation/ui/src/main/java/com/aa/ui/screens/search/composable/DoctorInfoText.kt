package com.aa.ui.screens.search.composable


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DoctorInfoText(
    title:String,
    text: String
){
    Row (
        modifier = Modifier
            .padding(start = 24.dp),
        verticalAlignment = Alignment.Top
    ){
        Text(
            text = "$title:",
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF000000),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF000000),
        )
    }
}