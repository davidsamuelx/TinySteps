package com.aa.ui.screens.phase_1.search.music

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.ui.R
import com.aa.ui.screens.phase_1.composable.shimmerEffect

@Composable
fun MusicLoadingScreen(
    modifier: Modifier=Modifier
){
    Surface {
        Column (
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF)),

            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top
        ){
            Spacer(modifier = modifier.height(24.dp))
            Box(
                modifier = modifier
                    .height(343.dp)
                    .width(343.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .shimmerEffect()
            )
            Spacer(modifier = modifier.height(32.dp))
            Box(
                modifier = modifier
                    .padding(horizontal = 24.dp)
                    .height(25.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .align(Alignment.CenterHorizontally)
                    .shimmerEffect()
            )
            Spacer(modifier = modifier.height(40.dp))
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(8.dp)
                    .clip(CircleShape)
                    .shimmerEffect()
            )
            Spacer(modifier = modifier.height(32.dp))
            Row(
                modifier = modifier
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {



                    Icon(
                        painter = painterResource(id = R.drawable.backward),
                        tint = Color(0xFFF9BAA7),
                        contentDescription = "Rewind 10 seconds"
                    )

                Spacer(modifier = modifier.width(30.dp))

                Box(
                    modifier = modifier
                        .size(80.dp)
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFFFF8865),
                                    Color(0xFFFF3A00)
                                )
                            ),
                            shape = CircleShape
                        )
                        .clip(CircleShape),
                ) {
                    Icon(
                        painter = painterResource( R.drawable.baseline_play_arrow_24),
                        tint = Color.White,
                        modifier = modifier
                            .size(48.dp)
                            .align(Alignment.Center) ,
                        contentDescription = "Play/Pause"
                    )
                }
                Spacer(modifier = modifier.width(30.dp))


                    Icon(
                        painter = painterResource(id = R.drawable.forward),
                        tint = Color(0xFFF9BAA7),
                        contentDescription = "Forward 10 seconds"
                    )

            }
        }
    }
}
@Preview
@Composable
fun PreviewDetails(){
    MusicLoadingScreen()
}