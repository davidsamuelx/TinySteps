package com.aa.viewmodels.discover_screen

import androidx.compose.ui.graphics.Color
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.viewmodels.R

data class DiscoverScreenUiState(
    val discoverList: List<DiscoverItem> = listOf(
        DiscoverItem(
            icon = R.drawable.nutrition_icon,
            text = "Nutrition",
            color = Color(0xFFFCDCD3)
        ),DiscoverItem(
            icon = R.drawable.bad_habit_icon,
            text = "Bad habit",
            color = Color(0xFFDED3FC)
        ),DiscoverItem(
            icon = R.drawable.music,
            text = "Music",
            color = Color(0xFFFFF4CC)
        ),DiscoverItem(
            icon = R.drawable.sleep__icon,
            text = "Sleeping positions",
            color = Color(0xFFFFE5E5)
        ),DiscoverItem(
            icon = R.drawable.exercise_icon,
            text = "Exercise",
            color = Color(0xFFD5ECE0)
        ),DiscoverItem(
            icon = R.drawable.special_case_icon,
            text = "Nutrition",
            color = Color(0xFFBBE5FA)
        )
    ),
        val isLoading : Boolean = true,
        val error: BaseErrorUiState? = null,
):BaseUiState


data class DiscoverItem(
    val icon: Int,
    val text: String,
    val color: Color,
)