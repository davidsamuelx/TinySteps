package com.aa.viewmodels.phase_3.kids_discover

import androidx.compose.ui.graphics.Color
import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.viewmodels.R

data class KidsDiscoverUiState(
    val discoverList: List<KidsDiscoverItem> = listOf(
        KidsDiscoverItem(
            icon = R.drawable.nutrition_icon,
            text = "Nutrition",
            color = Color(0xFFFCDCD3),
            destination = "kidsFoodScreen"
        ), KidsDiscoverItem(
            icon = R.drawable.bad_habit_icon,
            text = "Bad habit",
            color = Color(0xFFDED3FC),
            destination = "kidsBadHabitsScreen"
        ), KidsDiscoverItem(
            icon = R.drawable.sleep__icon,
            text = "Education",
            color = Color(0xFFFFE5E5),
            destination = "educationScreen"
        ), KidsDiscoverItem(
            icon = R.drawable.special_case_icon,
            text = "Special Case",
            color = Color(0xFFBBE5FA),
            destination = "kidsSpecialCaseScreen"
        ),
        KidsDiscoverItem(
            icon = R.drawable.game,
            text = "Difference of image",
            color = Color(0xFFFFF4CC),
            destination = "diffOfImageScreen"
        ),
        KidsDiscoverItem(
            icon =R.drawable.game,
            text = "Math Land",
            color = Color(0xFFD5ECE0),
            destination = "mathLandScreen"
        ),
        KidsDiscoverItem(
            icon = R.drawable.game,
            text = "Animal sound",
            color = Color(0xFFFCDCD3),
            destination = "animalSoundScreen"
        )
    ),
    val isLoading : Boolean = true,
    val error: BaseErrorUiState? = null,
): BaseUiState


data class KidsDiscoverItem(
    val icon: Int,
    val text: String,
    val color: Color,
    val destination: String
)