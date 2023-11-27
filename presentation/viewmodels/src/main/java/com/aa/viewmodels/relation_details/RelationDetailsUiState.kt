package com.aa.viewmodels.relation_details

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsRelationEntity

data class RelationDetailsUiState(
    val relation: RelationDetailsItemUiState = RelationDetailsItemUiState(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
) : BaseUiState

data class RelationDetailsItemUiState(
    val id: Int = 0,
    val relationDetails: String = "",
    val doctorName: String = "",
    val relationTitle: String = "",
    val phoneDoctor: String = "",
    val doctorLocation: String = "",
)

fun InfantsRelationEntity.toDetailsUiState() = RelationDetailsItemUiState(
    id = id ?: 0,
    relationDetails = advice ?: "",
    doctorName = doctorName ?: "",
    relationTitle = title ?: "",
    phoneDoctor = phoneDoctor ?: "",
    doctorLocation = doctorLocation ?: "",
)
