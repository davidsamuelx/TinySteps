package com.aa.viewmodels.diff_images

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.DiffImageGameEntity

data class DiffOfTwoImagesUiState(
    val diffOfTwoImage:List<DiffOfTwoImagesItemUiState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null,
    val isCorrectAnswerSelected: Boolean = false,
    val isAnswerSelected: Boolean = false,
    val isGameFinish: Boolean = false,

    ):BaseUiState

data class DiffOfTwoImagesItemUiState(
    val id:Int=0,
    val pathImgOne:String = "" ,
    val pathImgTwo:String = "" ,
    val howManyDiff:Int = 0 ,
    val chooseOne:Int = 0,
    val chooseTwo:Int = 0,
    val chooseThree:Int = 0 ,
    val chooseFour:Int = 0,
)

fun DiffImageGameEntity.toUiState()= DiffOfTwoImagesItemUiState(
    id=id ?:0,
    pathImgOne=pathImgOne ?: "",
    pathImgTwo = pathImgTwo?: "",
    howManyDiff = howManyDifference?: 0,
    chooseOne = chooseOne?: 0,
    chooseTwo=chooseTwo?: 0,
    chooseThree=chooseThree?: 0,
    chooseFour=chooseFour?: 0
)

