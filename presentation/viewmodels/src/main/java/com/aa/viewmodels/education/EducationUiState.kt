package com.aa.viewmodels.education

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.EducationGameEntity

data class EducationUiState(
    val educationList: List<EducationItemUiState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class EducationItemUiState(
    val id: Int = 0 ,
    val soundUrl: String = "" ,
    val letter: String = "" ,
    val imagePath: String = "" ,
    val level:String =""
)
fun EducationGameEntity.toUiState() =EducationItemUiState(
    id=id,
    soundUrl = sound,
    letter=letter,
    imagePath = image,
    level = level
)
