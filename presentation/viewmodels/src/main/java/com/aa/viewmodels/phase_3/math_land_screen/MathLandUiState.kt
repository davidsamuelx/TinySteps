package com.aa.viewmodels.phase_3.math_land_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.MathLandEntity

data class MathLandUiState(
    val mathLandList: List<MathLandItemUiState> = emptyList(),
    val levels: List<String> = listOf("easy", "medium", "hard"),
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null,
    val isCorrectAnswerSelected: Boolean = false,
    val isAnswerSelected: Boolean = false,
    val isGameFinish: Boolean = false,
    val selectedLevel: String = "Easy",

): BaseUiState

data class MathLandItemUiState(
    val answer: String = "" ,
    val id: Int= 0 ,
    val levels: String = "" ,
    val pathImg1: String = "" ,
    val pathImg2: String = "" ,
    val pathImg3: String = "" ,
    val pathVoice: String = "" ,
    val title: String = "" ,
)

fun MathLandEntity.toUiState() = MathLandItemUiState(
    answer = answer,
    id = id,
    levels = levels,
    pathImg1 = pathImg1,
    pathImg2 = pathImg2,
    pathImg3 = pathImg3,
    pathVoice = pathVoice,
    title = title,
)