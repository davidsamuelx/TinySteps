package com.aa.ui.screens.phase_1.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aa.ui.screens.phase_1.search.composable.SearchBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemLoadingScreen(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    onSearchClicked: () -> Unit
) {
    val colorStops = arrayOf(
        0.8f to Color(0xFFF6F9FF),
        1f to Color.Transparent
    )


        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

              stickyHeader {

            Box (
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(colorStops = colorStops)
                    )

            ){
                SearchBar(
                    query = query,
                    onQueryChange = onQueryChange,
                    onSearchClicked = onSearchClicked)
            }
      }

            items(5) {
                Column() {
                    Box(
                        modifier = modifier
                            .height(180.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .clip(shape = RoundedCornerShape(size = 20.dp))
                            .border(
                                width = 1.dp,
                                color = Color(0xFFEAECF0),
                                shape = RoundedCornerShape(size = 20.dp)
                            )
                            .shimmerEffect()

                    )
                }
            }
        }
    
}
