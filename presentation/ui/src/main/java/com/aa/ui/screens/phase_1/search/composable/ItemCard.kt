package com.aa.ui.screens.phase_1.search.composable


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.R
import com.aa.ui.screens.phase_1.composable.ShimmerDiscover

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ItemCard(
    id: Int,
    modifier: Modifier,
    onClickItem: (Int) -> Unit,
    title: String,
    imageUrl: String,
    isLoading:Boolean
){
//    var  isLoadings by remember{
//        mutableStateOf(true)
//    }
    LaunchedEffect(key1 = false ){

        !isLoading
    }
    ShimmerDiscover(isLoading =isLoading,
        contextAfterLoading ={
            Card(
                modifier = modifier
                    .height(180.dp)
                    .wrapContentSize()
                    .clip(shape = RoundedCornerShape(size = 20.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFFEAECF0),
                        shape = RoundedCornerShape(size = 20.dp)
                    )
                    .clickable(onClick = { onClickItem(id) })
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFEAECF0)),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model=imageUrl,
                            placeholder = painterResource(id = R.drawable.placeholde_image)
                        ) ,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth()
                            .background(
                                Brush.verticalGradient(
                                    0F to Color.Transparent,
                                    .5F to Color.Black.copy(alpha = 0.5F),
                                    1F to Color.Black.copy(alpha = 0.8F)
                                )
                            )
                            .padding(bottom = 16.dp, start = 22.dp),
                        text = title,
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 32.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                        )
                    )
                }
            }
        }
    )

}

//@RequiresApi(Build.VERSION_CODES.Q)
//@Preview
//@Composable
//private fun SearchPreview() {
//    ItemCard {}
//}