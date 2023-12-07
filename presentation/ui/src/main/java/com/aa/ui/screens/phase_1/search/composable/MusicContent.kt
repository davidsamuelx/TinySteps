package com.aa.ui.screens.phase_1.search.composable

import android.annotation.SuppressLint
import android.content.Context
import android.media.MediaPlayer
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.R
import kotlinx.coroutines.delay
import java.io.FileNotFoundException


@SuppressLint("RememberReturnType")
@Composable
fun MusicPlayer(
    url: String,
    imageUrl: String,
    songName: String,
){
    val url = url

    val context = LocalContext.current

    var isPlaying by remember { mutableStateOf(false) }

    var progress by remember { mutableStateOf(0f) }

    val onPlayPauseClick: () -> Unit = {
        if (SongHelper.isNetworkAvailable(context)) {
            if (SongHelper.mediaPlayer == null) {
                SongHelper.playStream(url)
            } else if (isPlaying) {
                SongHelper.pauseStream()
            } else {
                SongHelper.playStream(url)
            }
            isPlaying = !isPlaying
        } else {
            if (isPlaying) {
                SongHelper.pauseStream()
                isPlaying = false
            }
            Toast.makeText(context, "Internet is not available", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            progress = if (SongHelper.getDuration() > 0) {
                (SongHelper.getCurrentPosition().toFloat() / SongHelper.getDuration().toFloat())
            } else {
                0f
            }
            delay(1000)
        }
    }

    Surface {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF)),

            horizontalAlignment = CenterHorizontally, verticalArrangement = Arrangement.Top
        ){
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = rememberAsyncImagePainter(
                    placeholder = painterResource(id = R.drawable.placeholde_image),
                    model = imageUrl.ifEmpty { R.drawable.placeholde_image },
                ) ,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(343.dp)
                    .width(343.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = songName,
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                    )
            )

            Spacer(modifier = Modifier.height(40.dp))

            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(8.dp)
                    .clip(CircleShape),
                color = Color(0xFFF15223),
                trackColor = Color(0xFFC4C4C4)
            )

            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = { SongHelper.seekTo(SongHelper.getCurrentPosition() - 10000) },
                    modifier = Modifier
                        .size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.backward),
                        tint = Color(0xFFF9BAA7),
                        contentDescription = "Rewind 10 seconds"
                    )
                }

                Spacer(modifier = Modifier.width(30.dp))

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

                Spacer(modifier = Modifier.width(30.dp))

                IconButton(
                    onClick = { SongHelper.seekTo(SongHelper.getCurrentPosition() + 10000) },
                    modifier = Modifier
                        .size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.forward),
                        tint = Color(0xFFF9BAA7),
                        contentDescription = "Forward 10 seconds"
                    )
                }

            }

        }
    }
}



@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun MusicPreview() {
    MusicPlayer("","","")
}


class SongHelper{
    companion object{
        var mediaPlayer: MediaPlayer? = null
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
                try {
                    setDataSource(url)
                    prepareAsync()
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }
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

