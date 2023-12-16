package com.aa.ui.screens.phase_3.education.composable

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.R
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar


@SuppressLint("RememberReturnType")
@Composable
fun EducationContent(
    url: String,
    imageUrl: String,
    letter: String,
    navController: NavController,
    ){
    val url = url

    var isPlaying by remember { mutableStateOf(false) }


    val onPlayPauseClick: () -> Unit = {
        if (isPlaying) {
            SongHelper.pauseStream()
        } else {
            SongHelper.playStream(url)
        }
        isPlaying = !isPlaying
    }

    Surface {
        Column (
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            CustomToolbar(navController = navController, title = "")

            Spacer(modifier = Modifier.height(42.dp))

            Text(
                modifier = Modifier
                    .height(110.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal =  41.dp),
                text = letter,
                style = TextStyle(
                    fontSize = 40.sp,
                    lineHeight = 55.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFF3A00),
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = rememberAsyncImagePainter(imageUrl) ,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(202.dp)
                    .width(357.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(52.dp))

            Box(
                modifier = Modifier
                    .size(347.dp, 185.dp)
                    .background(Color(0xFFF6F9FF))
                    .clip(RoundedCornerShape(16.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFFF15223),
                        shape = RoundedCornerShape(16.dp)

                    )
            ) {
                Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)

            )
                {
                    Spacer(modifier = Modifier.height(24.dp))
                    IconButton(
                    onClick = onPlayPauseClick,
                    modifier = Modifier
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
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Icon(
                        painter = painterResource(id = if (isPlaying) R.drawable.baseline_pause_24 else R.drawable.baseline_play_arrow_24),
                        tint = Color.White,
                        modifier = Modifier.size(48.dp),
                        contentDescription = "Play/Pause"
                    )
                }
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal =  41.dp),
                        text = "Tap to play",
                        style = TextStyle(
                            fontSize = 13.sp,
                            lineHeight = 17.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFF3A00),
                            textAlign = TextAlign.Center
                        )
                    )
            }


            }

        }
    }
}



@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun EducationPreview() {
    val navController = rememberNavController()
    EducationContent("","","",navController)
}


class SongHelper{
    companion object{
        private var mediaPlayer: MediaPlayer? = null
        private var currentPosition = 0

        fun playStream(url: String){
            mediaPlayer?.let {
                if (it.isPlaying){
                    mediaPlayer?.stop()
                    mediaPlayer?.reset()
                }
            }
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer().apply {
                setDataSource(url)
                prepareAsync()
                mediaPlayer?.setOnCompletionListener {
                    Companion.currentPosition = 0

                }
            }
            mediaPlayer?.setOnPreparedListener{ mediaPlayer ->
                currentPosition = 0
                mediaPlayer.seekTo(currentPosition)
                mediaPlayer.start()
            }

        }

        fun pauseStream(){
            mediaPlayer?.let{
                currentPosition = it.currentPosition
                it.pause()
            }
        }

        fun stopStream(){
            mediaPlayer?.stop()
            mediaPlayer?.reset()
            currentPosition = 0
        }

        fun releasePlayer(){
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = null
            currentPosition = 0
        }

        fun getDuration(): Int {
            return mediaPlayer?.duration ?: 0
        }

        fun getCurrentPosition(): Int {
            return mediaPlayer?.currentPosition ?: 0
        }

        fun seekTo(position: Int) {
            mediaPlayer?.seekTo(position)
        }

    }
}