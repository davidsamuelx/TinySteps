package com.aa.ui.screens.phase_1.details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aa.ui.screens.phase_1.composable.shimmerEffect
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar

@Composable
fun DetailsLoadingScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
){
    val scrollState = rememberScrollState()

    Surface {

        Column(
            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {

            CustomToolbar(navController = navController, title = "")

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color(0xFFF6F9FF))
                    .verticalScroll(state = scrollState),

                horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = modifier.height(12.dp))

                Box(
                    modifier = modifier
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .height(250.dp)
                        .shimmerEffect()
                    ,
                )
                Box(

                    modifier = modifier
                        .align(Alignment.Start)
                        .padding(
                            start = 16.dp,
                            top = 16.dp,
                            bottom = 12.dp)
                        .width(250.dp)
                        .height(25.dp)
                        .align(Alignment.Start)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()

                )
                Box(
                    modifier = modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                        .align(Alignment.Start)
                        .height(25.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()

                )
                Box(
                    modifier = modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .fillMaxWidth()
                        .align(Alignment.Start)
                        .height(25.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()

                    )
                Box(

                    modifier = modifier
                        .align(Alignment.Start)
                        .padding(start = 8.dp,
                            top = 48.dp,
                            bottom = 12.dp)
                        .width(200.dp)
                        .height(25.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()
                )
                Box(
                    modifier = modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .width(250.dp)
                        .align(Alignment.Start)
                        .height(25.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()

                )
                Box(
                    modifier = modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .width(250.dp)
                        .align(Alignment.Start)
                        .height(25.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()

                )
                Box(
                    modifier = modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .width(250.dp)
                        .align(Alignment.Start)
                        .height(25.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()

                )
                Box(

                    modifier = modifier
                        .align(Alignment.Start)
                        .padding(
                            start = 8.dp,
                            end=8.dp,
                            top = 16.dp,
                            bottom = 12.dp)
                        .fillMaxWidth()
                        .height(25.dp)
                        .align(Alignment.Start)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()

                )
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun DetailsPreview() {
    val navController = rememberNavController()
    DetailsLoadingScreen(navController = navController )
}