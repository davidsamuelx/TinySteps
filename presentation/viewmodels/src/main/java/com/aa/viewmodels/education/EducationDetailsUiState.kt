package com.aa.viewmodels.education

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.LetterEntity

data class EducationDetailsUiState(
    val education: EducationDetailsItemUiState = EducationDetailsItemUiState(),
    val query: String = "",
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class EducationDetailsItemUiState(
    val id: Int = 0 ,
    val soundUrl: String = "" ,
    val letter: String = "" ,
    val imagePath: String = "" ,
    val level:String =""
)
fun LetterEntity.toDetailsUiState() =EducationDetailsItemUiState(
    id=id,
    soundUrl = sound,
    letter=letter,
    imagePath = image,
    level = levels
)
