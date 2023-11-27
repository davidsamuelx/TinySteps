package com.aa.viewmodels.infant_discover

import androidx.compose.ui.graphics.Color
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.viewmodels.R

data class InfantDiscoverUiState(
    val discoverList: List<InfantDiscoverItem> = listOf(
        InfantDiscoverItem(
            icon = R.drawable.nutrition_icon,
            text = "Nutrition",
            color = Color(0xFFFCDCD3),
            destination = "infantsFoodScreen"
        ), InfantDiscoverItem(
            icon = R.drawable.bad_habit_icon,
            text = "Bad habit",
            color = Color(0xFFDED3FC),
            destination = "infantsBadHabitScreen"
        ), InfantDiscoverItem(
            icon = R.drawable.productt,
            text = "Product",
            color = Color(0xFFFFF4CC),
            destination = "infantsProductsScreen"
        ), InfantDiscoverItem(
            icon = R.drawable.sleep__icon,
            text = "Sleeping positions",
            color = Color(0xFFFFE5E5),
            destination = "infantsSleepScreen"
        ), InfantDiscoverItem(
            icon = R.drawable.exercise_icon,
            text = "Exercise",
            color = Color(0xFFD5ECE0),
            destination = "infantsExerciseScreen"
        ), InfantDiscoverItem(
            icon = R.drawable.special_case_icon,
            text = "Special Case",
            color = Color(0xFFBBE5FA),
            destination = "infantsSpecialCaseScreen"
        )
    ),
    val isLoading : Boolean = true,
    val error: BaseErrorUiState? = null,
): BaseUiState


data class InfantDiscoverItem(
    val icon: Int,
    val text: String,
    val color: Color,
    val destination: String
)