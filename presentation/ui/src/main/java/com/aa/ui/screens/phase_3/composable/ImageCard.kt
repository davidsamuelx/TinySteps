package com.aa.ui.screens.phase_3.composable

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.R
import com.aa.ui.screens.phase_1.composable.VerticalSpacer

@Composable
fun ImageCard(
    image1:String,
     image2:String
){
    Log.d("ImageCard", "Image1: $image1, Image2: $image2")

    Column (
        modifier = Modifier
            .wrapContentSize()
            .background(Color(0xFFF6F9FF))
    ){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(192.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)

    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model =image1,
                placeholder = painterResource(id = R.drawable.placeholde_image)) ,
            contentDescription = "image_1",
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(
                    topStart = 16.dp,
                    bottomStart = 16.dp))

        )
        Divider(
            color = Color(0xFFF6F9FF),
            modifier = Modifier
                .fillMaxHeight()  //fill the max height
                .width(8.dp)

        )
        Image(
            painter = rememberAsyncImagePainter(
                model =image2,
                placeholder = painterResource(id = R.drawable.placeholde_image)) ,
            contentDescription = "image_2",
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(
                    topEnd = 16.dp,
                    bottomEnd = 16.dp
                    ))
        )

    }
        VerticalSpacer(space = 32.dp)

        Text(
            text = "How many differences ? ",
           style = androidx.compose.ui.text.TextStyle(
               fontSize = 18.sp,
               lineHeight = 24.sp,
               fontWeight = FontWeight(500),
               color = Color.Black,
           ),
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )
        VerticalSpacer(space = 16.dp)
    }
}
//@Preview
//@Composable
//fun PreviewImage(){
//    ImageCard()
//
//}