//package com.aa.ui.screens.search.composable
//
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import com.aa.base.viewmodels.badhabit.BadHabitUIState
//
//@RequiresApi(Build.VERSION_CODES.Q)
//@Composable
//fun CategoryContent(
//    state: BadHabitUIState,
//    onClickSearch: () -> Unit = {},
//    onClickCard: () -> Unit = {},
//    navController: NavController,
//){
//    val badHabitState = rememberLazyListState()
//
//    Surface {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color(0xFFF6F9FF)),
//
//            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
//        ) {
//
//            CustomToolbar(navController = navController, title = "Bad Habit")
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            SearchBar(query =  "" , onQueryChange = {} , onSearchClicked = {})
//
//            LazyColumn(
//                contentPadding = PaddingValues(16.dp),
//                state = badHabitState,
//                verticalArrangement = Arrangement.spacedBy(12.dp)
//            ){
//                itemsIndexed(state.badHabitsList){index, item ->
//                    ItemCard(
//                        state = item,
//                        onClickItem = onClickCard,
//                        index = index
//                    )
//                }
//            }
//        }
//    }
//}