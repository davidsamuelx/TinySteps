package com.aa.ui.screens.phase_1.details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.screens.phase_1.details_screen.composables.CustomHeader
import com.aa.ui.screens.phase_1.home_screen.backToHomeScreen
import com.aa.viewmodels.baby_details_screen.BabyDetailsScreenViewModel
import com.aa.viewmodels.baby_details_screen.BabyDetailsUiState

@Composable
fun BabyDetailsScreen(
    navController: NavController,
    viewModel: BabyDetailsScreenViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    BabyDetailsContent(
        state = state,
        onBackClick = navController::backToHomeScreen
    )
}

@Composable
private fun BabyDetailsContent(
    state: BabyDetailsUiState,
    onBackClick : () -> Unit
) {
    LazyColumn() {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                CustomHeader(onBackClick,"Baby Info")
                Image(
                    painter = rememberAsyncImagePainter(model = state.babyImage),
                    contentDescription = "Baby Image",
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.FillBounds,
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Your Baby", style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                    ),
                    modifier = Modifier.padding(bottom = 12.dp, start = 16.dp,end = 16.dp)
                )

                Text(
                    text = state.babyInfo, style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Black,
                    ),
                    modifier = Modifier.padding(bottom = 12.dp, start = 16.dp,end = 16.dp)
                )

            }
        }
    }
}


@Preview
@Composable
fun BabyDetailsContentPreview() {
    BabyDetailsContent(state = BabyDetailsUiState(),{})
}