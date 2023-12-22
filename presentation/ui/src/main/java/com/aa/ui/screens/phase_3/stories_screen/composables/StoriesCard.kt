package com.aa.ui.screens.phase_3.stories_screen.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun StoriesCard(
    modifier: Modifier,
    title: String,
    url: String,
    exoPlayer: SimpleExoPlayer
) {
    val context = LocalContext.current

    Card(
        modifier = modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(size = 8.dp))
            .background(Color.White)
            .border(
                width = 1.dp,
                color = Color(0xFFDCE4E6),
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(bottom = 8.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(302.dp)
                .background(Color.White)
                .padding(horizontal = 4.dp)
        ) {

            AndroidView(
                factory = { context ->
                    PlayerView(context).apply {
                        player = exoPlayer
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .clip(RoundedCornerShape(size = 8.dp))
            )
        }

        Text(
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFFF15223),
                ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.background(Color.White).padding(vertical = 16.dp, horizontal = 12.dp)
        )


    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun StoriesPreview() {
//    StoriesCard(
//        modifier = Modifier,
//        title = "Story-berries - Fairy Tales, Bedtime Stories",
//        url = "https://tiny-steps.help/storage/uploads/Stories/path_video/170086161086mp4"
//    )
}