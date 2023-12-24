package com.aa.ui.screens.phase_3.home_screen.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.aa.viewmodels.phase_3.stories_screen.HomeKidsUiState
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoriesPager(
    state: HomeKidsUiState,
    pagerState: PagerState,
) {
    val width = 8.dp
    val height = 8.dp
    val circleSpacing = 6.dp
    val activeLineWidth = 18.dp
    val radius = CornerRadius(16f)
    val count = pagerState.pageCount
    val context = LocalContext.current
    val exoPlayers = remember { mutableMapOf<Int, SimpleExoPlayer>() }


    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CompositionLocalProvider (LocalOverscrollConfiguration provides null){
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .weight(0.96f),
                pageSpacing = 8.dp,
                contentPadding = PaddingValues(horizontal = 12.dp),
                beyondBoundsPageCount = 2,
            ) { page ->
                state.storiesList.getOrNull(
                    page % (state.storiesList.size)
                )?.let {data ->

                if (page in state.storiesList.indices) {

                    val exoPlayer = exoPlayers.getOrPut(page) {
                        SimpleExoPlayer.Builder(context).build().apply {
                            val dataSourceFactory = DefaultDataSourceFactory(
                                context, Util.getUserAgent(context, context.packageName)
                            )

                            val mediaItem = MediaItem.fromUri(data.videoPath)
                            val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                                .createMediaSource(mediaItem)

                            this.prepare(source)
                        }
                    }

                    LaunchedEffect(pagerState.currentPage) {
                        val previousPage = if (pagerState.currentPage == 0) {
                            state.storiesList.size - 1
                        } else {
                            pagerState.currentPage - 1
                        }

                        val nextPage = if (pagerState.currentPage == state.storiesList.size - 1) {
                            0
                        } else {
                            pagerState.currentPage + 1
                        }

                        exoPlayers[previousPage]?.playWhenReady = false
                        exoPlayers[nextPage]?.playWhenReady = false
                    }


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .graphicsLayer {
                                val pageOffset =
                                    ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
                                lerp(
                                    start = 8.7f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                )
                                scaleY = lerp(
                                    start = 0.8f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                )
                            }
                    ) {
                        StoriesCard(
                            modifier = Modifier,
                            title = data.title,
                            url = data.videoPath,
                            exoPlayer = exoPlayer
                        )
                    }
                }
            }
        }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(0.04f)
                    .padding(end = 70.dp),
                horizontalArrangement = Arrangement.Center
            ) {
            Canvas(
                modifier = Modifier
                    .wrapContentSize()

            ) {
                val spacing = circleSpacing.toPx()
                val dotWidth = width.toPx()
                val dotHeight = height.toPx()

                val activeDotWidth = activeLineWidth.toPx()
                var x = 0f
                val y = center.y

                repeat(pagerState.pageCount) { i ->
                    val posOffset = pagerState.pageOffset
                    val dotOffset = posOffset % 1
                    val current = posOffset.toInt()

                    val factor = (dotOffset * (activeDotWidth - dotWidth))

                    val calculatedWidth = when {
                        i == current -> activeDotWidth - factor
                        i - 1 == current || (i == 0 && posOffset > count - 1) -> dotWidth + factor
                        else -> dotWidth
                    }

                    drawIndicator(x, y, calculatedWidth, dotHeight, radius, i == current)
                    x += calculatedWidth + spacing
                }
            }}
        }
    }
        LaunchedEffect(key1 = Unit, block = {

            var initPage = Int.MAX_VALUE / 2

            while(initPage % state.storiesList.size != 0){
                initPage++
            }
            pagerState.scrollToPage(initPage)
        })
    }
}

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
private fun StoriesPagerPreview() {
    val pagerState = rememberPagerState(pageCount = { 10 })

}

private fun DrawScope.drawIndicator(
    x: Float,
    y: Float,
    width: Float,
    height: Float,
    radius: CornerRadius,
    isActive: Boolean
) {
    val rect = RoundRect(
        x,
        y - height / 2,
        x + width,
        y + height / 2,
        radius
    )
    val path = Path().apply { addRoundRect(rect) }
    val color = if (isActive) Color(0xFFF15223) else Color.LightGray
    drawPath(path = path, color = color)
}

@OptIn(ExperimentalFoundationApi::class)
val PagerState.pageOffset: Float
    get() = this.currentPage + this.currentPageOffsetFraction


@OptIn(ExperimentalFoundationApi::class)
fun PagerState.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffsetFraction
}

