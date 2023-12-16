package com.aa.ui.screens.phase_3.composable

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.ui.R
import com.aa.ui.screens.phase_1.search.composable.MusicPlayer
import com.aa.ui.screens.phase_1.search.composable.SongHelper

@Composable
fun PlayerBox(
    url: String,
    imageUrl: String,
    letter: String,
){
    val colorStops = arrayOf(
        0.8f to Color(0xFFFF8865),
        1f to Color(0xFFFF3A00)
    )
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
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF)),

            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top
        ){
            Text(
                modifier = Modifier
                    .height(90.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal =  41.dp),
                text = letter,
                style = TextStyle(
                    fontSize = 40.sp,
                    lineHeight = 55.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFF3A00),
                )
            )

        Box(
            modifier = Modifier
                .size(347.dp, 135.dp)
                .background(Color(0xFFF6F9FF))
                .clip(RoundedCornerShape(16.dp))
                .border(
                    width = 1.dp,
                    color = Color(0xFFF15223),
                    shape = RoundedCornerShape(16.dp)

                )
        ) {
            IconButton(
                onClick = {  },
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
                    .align(Alignment.Center)
            ) {
                Icon(
                    painter = painterResource(id = if (isPlaying) R.drawable.baseline_pause_24 else R.drawable.baseline_play_arrow_24),
                    tint = Color.White,
                    modifier = Modifier.size(48.dp),
                    contentDescription = "Play/Pause"
                )
            }

        }
}
    }
}
@Preview
@Composable
fun playerPreview(){
    MusicPlayer("","","")
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
            }
            mediaPlayer?.setOnPreparedListener{ mediaPlayer ->
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