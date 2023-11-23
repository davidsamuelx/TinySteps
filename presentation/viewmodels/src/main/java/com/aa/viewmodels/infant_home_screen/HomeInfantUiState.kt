package com.aa.viewmodels.infant_home_screen

import androidx.compose.ui.graphics.Color
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.viewmodels.R

data class HomeInfantUiState(
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null,
    val guidanceList: List<GuidanceUiItem> = emptyList(),
    val homeAdviseList: List<HomeAdvisesItem> = listOf(
        HomeAdvisesItem(
            icon = R.drawable.nutrition_icon,
            text = "Nutrition",
            color = Color(0xFFFCDCD3),
            destination = ""
        ), HomeAdvisesItem(
            icon = R.drawable.bad_habit_icon,
            text = "Bad habit",
            color = Color(0xFFDED3FC),
            destination = ""
        ), HomeAdvisesItem(
            icon = R.drawable.exercise_icon,
            text = "Exercise",
            color = Color(0xFFD5ECE0),
            destination = " "
        )
    ),
    val pagerImages: List<Int> = listOf(
        R.drawable.mother_1,
        R.drawable.mother_2,
        R.drawable.mother_3,
    )
): BaseUiState


data class HomeAdvisesItem(
    val icon: Int,
    val text: String,
    val color: Color,
    val destination: String
)

data class GuidanceUiItem(
    val id: Int = 0,
    val guidanceTitle: String = "",
    val image: String = "",
)

fun GuidanceInstructionEntity.toUiState() = GuidanceUiItem(
    id = 0,
    guidanceTitle = titleEN ?: "",
    image = ""
)