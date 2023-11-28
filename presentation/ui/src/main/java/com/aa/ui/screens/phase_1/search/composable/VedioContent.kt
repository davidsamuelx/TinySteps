package com.aa.ui.screens.phase_1.search.composable

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ui.PlayerView

@SuppressLint("RememberReturnType")
@Composable
fun VideoPlayer(
    url: String,
){
    val context = LocalContext.current

    Surface {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F9FF)),

            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top
        ){
            val exoPlayer = remember(context){
                SimpleExoPlayer.Builder(context).build().apply {
                    val dataSourceFactory = DefaultDataSourceFactory(
                        context, Util.getUserAgent(context, context.packageName)
                    )

                    val mediaItem = MediaItem.fromUri(url)
                    val source = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem)

                    this.prepare(source)
                }

            }



            AndroidView(
                factory = { context ->
                    PlayerView(context).apply {
                        player = exoPlayer
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
            Log.d("VideoPlayer", "Video URL: $url")
        }
    }


}