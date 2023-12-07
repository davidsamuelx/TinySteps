package com.aa.ui.screens.phase_2.infant_home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aa.ui.screens.phase_1.composable.shimmerEffect

@Composable
fun InfantsHomeLoadingScreen(
    modifier: Modifier = Modifier,
) {
    Column {
        Box(

            modifier = Modifier
                .padding(horizontal = 24.dp)
                .height(25.dp)
                .width(150.dp)
                .shimmerEffect()
        )

        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(5) {
                Row() {
                    Box(
                        modifier = modifier
                            .width(232.dp)
                            .height(156.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .shimmerEffect()
                    )
                }
            }
        }
    }



}
@Preview
@Composable
private fun DetailsPreview() {
    InfantsHomeLoadingScreen()
}