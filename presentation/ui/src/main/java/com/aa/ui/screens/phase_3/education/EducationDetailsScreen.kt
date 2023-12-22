package com.aa.ui.screens.phase_3.education

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.aa.ui.R
import com.aa.ui.screens.phase_1.navigation_bar.NavigationBar
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.ui.screens.phase_3.kids_games.animal_sound_screen.composables.GamesPlayer
import com.aa.ui.screens.phase_3.kids_games.animal_sound_screen.composables.GamesSongHelper
import com.aa.viewmodels.phase_3.education.EducationDetailsUiState
import com.aa.viewmodels.phase_3.education.EducationDetailsViewModel

@Composable
fun EducationDetailsScreen(
    viewModel: EducationDetailsViewModel = hiltViewModel(),
    navController: NavController,
    ) {
    val state by viewModel.state.collectAsState()

    DisposableEffect(Unit) {
        onDispose {
            GamesSongHelper.releasePlayer()
        }
    }
        EducationDetailsContent(
            state = state,
            navController=navController
        )
}
@Composable
fun EducationDetailsContent(
    state: EducationDetailsUiState,
    navController: NavController,
    ){
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()){


            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ){
                CustomToolbar(navController = navController, title = "")

                Spacer(modifier = Modifier.height(42.dp))

                Text(
                    modifier = Modifier
                        .height(70.dp)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(horizontal = 41.dp),
                    text = state.education.letter,
                    style = TextStyle(
                        fontSize = 40.sp,
                        lineHeight = 55.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFF3A00),
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))

                Image(
                    painter = rememberAsyncImagePainter(
                        model = state.education.imagePath,
                        placeholder = painterResource(id = R.drawable.placeholde_image)
                    ) ,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(200.dp)
                        .width(357.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                )
                Spacer(modifier = Modifier.height(52.dp))

                Box(
                    modifier = Modifier
                        .size(347.dp, 185.dp)
                        .background(Color(0xFFF6F9FF))
                        .clip(RoundedCornerShape(16.dp))
                        .border(
                            width = 1.dp,
                            color = Color(0xFFF15223),
                            shape = RoundedCornerShape(16.dp)

                        )
                ) {
                    GamesPlayer(url = state.education.soundUrl)


                }
            }
            NavigationBar(
                navController = navController,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(12.dp),
            )
        }
    }


}