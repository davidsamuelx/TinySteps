package com.aa.viewmodels.home_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState

data class HomeUiState(
    val weekId: Int = 1,
    val calender: List<Int> = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40) ,
    val babyImage : String = "https://tiny-steps.help/storage/uploads/path_img/EsME7cqQqDgaA9psJwM5c86PJk5TYDsTiR5Q3h6T.png",
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null,
    val isError: Boolean = false,
    val babyInfo: String = "The embryo is now called a fetus. It is about the size of a lentil, and it is beginning to look more...",
    val period: String = "Week",
    val selectedCalendarItem: Int = 2
):BaseUiState


