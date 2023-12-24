package com.aa.ui.screens.phase_3.animal_sound_screen.composables

import android.content.Context
import android.media.MediaPlayer
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aa.ui.R
import kotlinx.coroutines.delay

@Composable
fun GamesPlayer(
    url: String,
    modifier: Modifier = Modifier,
) {
    val url = url

    val context = LocalContext.current

    var isPlaying by remember { GamesSongHelper.isPlaying }

    var progress by remember { mutableStateOf(0f) }

    val onPlayPauseClick: () -> Unit = {
        if (GamesSongHelper.isNetworkAvailable(context)) {
            if (url.isEmpty()) {
                Toast.makeText(context, "Please select your animal", Toast.LENGTH_SHORT).show()
            } else {
                if (GamesSongHelper.mediaPlayer == null) {
                    GamesSongHelper.playStream(url)
                } else if (isPlaying) {
                    GamesSongHelper.pauseStream()
                } else {
                    if (GamesSongHelper.getCurrentPosition() == GamesSongHelper.getDuration()) {
                        GamesSongHelper.seekTo(0) // Reset the play position to the beginning
                    }
                    GamesSongHelper.playStream(url)
                }
                isPlaying = !isPlaying
            }
        } else {
            if (isPlaying) {
                GamesSongHelper.pauseStream()
                isPlaying = false
            }
            Toast.makeText(context, "Internet is not available", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            if (GamesSongHelper.getCurrentPosition() == GamesSongHelper.getDuration()) {
                break
            }
            progress = if (GamesSongHelper.getDuration() > 0) {
                (GamesSongHelper.getCurrentPosition().toFloat() / GamesSongHelper.getDuration().toFloat())
            } else {
                0f
            }
            delay(1000)
        }
    }

    LaunchedEffect(GamesSongHelper.mediaPlayer) {
        GamesSongHelper.mediaPlayer?.setOnCompletionListener {
            isPlaying = false
            progress = 0f
        }
        GamesSongHelper.mediaPlayer?.setOnPreparedListener {
            isPlaying = true
        }
    }
    Box(
        modifier = modifier
            .height(192.dp)
            .wrapContentWidth()
            .background(Color(0xFFF6F9FF))
            .border(1.dp, Color(0xFFF15223), RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {

                Image(
                    painter = painterResource(id = R.drawable.player_arcs),
                    contentDescription = "",
                    modifier = Modifier.rotate(180f)
                        .width(30.dp)
                        .height(80.dp)
                )

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
                        .clip(CircleShape),
                ) {
                    Icon(
                        painter = painterResource(id = if (isPlaying) R.drawable.baseline_pause_24 else R.drawable.baseline_play_arrow_24),
                        tint = Color.White,
                        modifier = Modifier.size(48.dp),
                        contentDescription = "Play/Pause"
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.player_arcs),
                    contentDescription = "",
                    modifier = Modifier
                        .width(30.dp)
                        .height(80.dp)
                )
            }
            Text(
                text = "Tap to play",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFF15223),
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }

}


@Preview
@Composable
fun GamesPlayerPreview() {
    GamesPlayer(url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
}

class GamesSongHelper{
    companion object{
        var mediaPlayer: MediaPlayer? = null
        private var currentPosition = 0
        var isPlaying = mutableStateOf(false)

        fun updateProgress(): Float {
            return if (getDuration() > 0) {
                getCurrentPosition().toFloat() / getDuration().toFloat()
            } else {
                0f
            }
        }


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
                isPlaying.value = true
            }
            mediaPlayer?.setOnCompletionListener {
                mediaPlayer?.reset()
                currentPosition = 0
                isPlaying.value = false
            }
        }

        fun pauseStream(){
            mediaPlayer?.let{
                currentPosition = it.currentPosition
                it.pause()
                isPlaying.value = false
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

        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val network = connectivityManager.activeNetwork ?: return false
                val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
                return when {
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            } else {
                val networkInfo = connectivityManager.activeNetworkInfo ?: return false
                return networkInfo.isConnected
            }
        }

    }
}