package com.aa.ui.screens.phase_2.infant_home_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.R

@Composable
fun GuidanceCard(
    id: Int,
    modifier: Modifier = Modifier,
    image: String,
    text: String,
    onCardClick: (Int) -> Unit
){
    Box(
        modifier = modifier
            .clickable { onCardClick(id) }
            .width(200.dp)
            .height(140.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFF8865), Color(0xFFFF3A00))
                )
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
           Image(
               painter = rememberAsyncImagePainter(
                   model=image,
                   placeholder = painterResource(id = R.drawable.placeholde_image)
                   ),
               contentDescription = "",
               contentScale = ContentScale.Crop,
               modifier = Modifier
                   .height(80.dp)
                   .fillMaxWidth()
           )
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 12.dp)
                    .align(Alignment.Start)
            ){
                Image(
                    painter = painterResource(id = R.drawable.folder) ,
                    contentDescription = "" 
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardPreview() {
    GuidanceCard(
        id = 0,
        image = "",
        text = "",
        onCardClick = {}
    )
}