package com.aa.ui.screens.phase_1.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.ui.screens.phase_1.composable.shimmerEffect

@Composable
fun HomeLoadingScreen(
    modifier:Modifier=Modifier
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
    ) {
        item {
                Box {
                    Column {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            contentPadding = PaddingValues(vertical = 12.dp)
                        ) {
                            items(10){
                                Box(
                                    modifier = modifier
                                        .size(72.dp, 84.dp)
                                        .padding(
                                            start = 8.dp,
                                            end = 8.dp,
                                            top = 12.dp,
                                            bottom = 12.dp)
                                        .clip(RoundedCornerShape(16.dp))
                                        .shimmerEffect()
                                )
                            }

                        }
                        Box(
                            modifier = modifier
                                .size(344.dp, 368.dp)
                                .align(Alignment.CenterHorizontally)
                                .clip(RoundedCornerShape(16.dp))
                                .shimmerEffect()
                        )
                        Spacer(modifier = modifier.height(12.dp))
                        Box(
                            modifier = modifier
                                .align(Alignment.CenterHorizontally)
                                .clip(RoundedCornerShape(16.dp))
                                .shimmerEffect()
                                .size(344.dp, 158.dp)
                                .padding(
                                    start = 24.dp,
                                    top = 16.dp,
                                    end = 16.dp,
                                    bottom = 12.dp)

                        )
                        Spacer(modifier = modifier.height(16.dp))
                        Box(
                            modifier = modifier
                                .align(Alignment.CenterHorizontally)
                                .clip(RoundedCornerShape(16.dp))
                                .shimmerEffect()
                                .height(72.dp)
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 12.dp)

                        )
                        Spacer(modifier = modifier.height(24.dp))
                    }
                }


            }
    }
}
@Preview
@Composable
private fun DetailsPreview() {
    HomeLoadingScreen()
}