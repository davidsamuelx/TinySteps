package com.aa.viewmodels.baby_details_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState

data class BabyDetailsUiState(
    val babyImage : String = "https://tiny-steps.help/storage/uploads/path_img/EsME7cqQqDgaA9psJwM5c86PJk5TYDsTiR5Q3h6T.png",
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null,
    val babyInfo: String = "The embryo is now called a fetus. It is about the size of a lentil, and it is beginning to look more...",
    val weekNumber: Int = 1,
): BaseUiState
