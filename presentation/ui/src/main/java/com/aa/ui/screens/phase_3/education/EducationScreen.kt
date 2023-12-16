package com.aa.ui.screens.phase_3.education

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.screens.phase_1.search.composable.CustomToolbar
import com.aa.ui.screens.phase_3.education.composable.LetterCard
import com.aa.viewmodels.education.EducationItemUiState
import com.aa.viewmodels.education.EducationUiState
import com.aa.viewmodels.education.EducationViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun EducationScreen(
    navController: NavController,
    viewModel:EducationViewModel= hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    educationContent(
        state = state,
        navController = navController,
        onClickCard = navController::navigateToEducationDetailsScreen
    )
}
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
private fun educationContent(
    state: EducationUiState,
    onClickCard: (Int) -> Unit = {},
    navController: NavController,
){
    val easyState = rememberLazyListState()
    val mediumState = rememberLazyListState()
    val diffState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F9FF))
    ){
        Column( modifier = Modifier
            .padding(bottom = 64.dp)
        ) {
            CustomToolbar(navController = navController, title = "Education")

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                item {

            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            Text(
                text = "Easy",
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF040415),
                )
            )
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            LazyRow(
                contentPadding = PaddingValues(horizontal = 12.dp),
                state = easyState,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {

                itemsIndexed(state.educationList) { index, item ->

                if (item.level == "Easy") {
                            LetterCard(
                                id = item.id,
                                image = item.imagePath,
                                text = item.letter,
                                onClickItem ={onClickCard(item.id)}
                            )
                        }

                }
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))

            Text(
            text = "Medium",
            modifier = Modifier
                .padding(horizontal = 24.dp),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF040415),
            )
            )

        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            state = mediumState
        ){

            itemsIndexed(state.educationList) { index, item ->


            if (item.level=="Medium"){
                        LetterCard(
                            id =item.id,
                            image =item.imagePath ,
                            text =item.letter ,
                            onClickItem =onClickCard
                        )
                    }

            }
        }

        Spacer(modifier = Modifier.padding(vertical = 12.dp))


            Text(
            text = "Hard",
            modifier = Modifier
                .padding(horizontal = 24.dp),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF040415),
            )
        )
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            state = diffState,

        ){

            itemsIndexed(state.educationList) { index, item ->
                    if (item.level=="High"){
                        LetterCard(
                            id =item.id,
                            image =item.imagePath ,
                            text =item.letter ,
                            onClickItem =onClickCard
                        )
                    }
                }
            }
        }
    }
}
        }
        }

@Composable
private fun itemMatchesQuery(item: EducationItemUiState, query: String): Boolean {
    return item.letter.contains(query, ignoreCase = true)
}