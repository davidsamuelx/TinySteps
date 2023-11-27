package com.aa.ui.screens.infant_home_screen.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp

import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aa.viewmodels.infant_home_screen.HomeInfantUiState
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePager(
    state: HomeInfantUiState,
    pagerState: PagerState,
){

    var currentPage by remember { mutableStateOf(pagerState.currentPage) }

    LaunchedEffect(true) {
        while(true){
        delay(10000)

            currentPage += if (currentPage < state.pagerImages.size - 1) 1 else -currentPage

        pagerState.animateScrollToPage(currentPage)
        }
    }


    HorizontalPager(
        modifier = Modifier,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 24.dp),
        pageSpacing = 8.dp
    ) { pageIndex ->
            Card(
                modifier = Modifier
                    .aspectRatio(16.5f / 9f)
                    .clip(RoundedCornerShape(24.dp))
                    .graphicsLayer {
                        val pageOffset =
                            ((pagerState.currentPage - pageIndex) + pagerState.currentPageOffsetFraction).absoluteValue
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
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(state.pagerImages[pageIndex]).build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
}
