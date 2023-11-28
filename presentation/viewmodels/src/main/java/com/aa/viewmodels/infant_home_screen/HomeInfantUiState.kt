package com.aa.viewmodels.infant_home_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.GuidanceInstructionEntity
import com.aa.models.infants.InfantsRelationEntity
import com.aa.viewmodels.R

data class HomeInfantUiState(
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null,
    val guidanceList: List<GuidanceUiItem> = emptyList(),
    val relationList: List<RelationUiItem> = emptyList(),
    val pagerImages: List<Int> = listOf(
        R.drawable.mother_1,
        R.drawable.mother_2,
        R.drawable.mother_3,
    )
): BaseUiState


data class RelationUiItem(
    val id: Int,
    val title: String,
    val text: String,
)

data class GuidanceUiItem(
    val id: Int = 0,
    val guidanceTitle: String = "",
    val image: String = "",
)

fun GuidanceInstructionEntity.toUiState() = GuidanceUiItem(
    id = id ?: 0,
    guidanceTitle = titleEN ?: "",
    image = image ?: ""
)

fun InfantsRelationEntity.toUiState() = RelationUiItem(
    id = id ?: 0,
    title = title ?: "",
    text = advice ?: ""
)