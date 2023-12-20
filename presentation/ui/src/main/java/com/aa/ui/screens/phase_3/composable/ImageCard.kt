package com.aa.ui.screens.phase_3.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.R
import com.aa.ui.screens.phase_1.composable.VerticalSpacer

@Composable
fun ImageCard(
    image1:String,
    image2:String
) {
    Column(
        modifier = Modifier.wrapContentSize()
            .padding(16.dp)

    ) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(192.dp)
                .background(Color.White)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                ,Arrangement.SpaceBetween
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = image1,
                        placeholder = painterResource(id = R.drawable.placeholde_image)
                    ),
                    contentDescription = "babyImage",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.weight(0.1f)
                        .fillMaxHeight()
                        .padding(end = 4.dp),
                )
                VerticalSpacer(space = 8.dp)
                Image(
                    painter = rememberAsyncImagePainter(
                        model = image2,
                        placeholder = painterResource(id = R.drawable.placeholde_image)
                    ),
                    contentDescription = "babyImage",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.weight(0.1f)
                        .fillMaxHeight()
                        .padding(start = 4.dp),
                )
            }


        }
    }
}
//@Preview
//@Composable
//fun PreviewImage(){
//    ImageCard()
//
//}