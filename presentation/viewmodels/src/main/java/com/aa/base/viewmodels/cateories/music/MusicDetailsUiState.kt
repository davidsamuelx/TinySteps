package com.aa.base.viewmodels.cateories.music

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.MusicEntity

data class MusicDetailsUiState(
    val music: MusicDetailsItemUiState = MusicDetailsItemUiState(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class MusicDetailsItemUiState(
    val id: Int = 0 ,
    val musicUrl: String = "" ,
    val musicType: String = "" ,
    val imagePath: String = "" ,
)

fun MusicEntity.toDetailsUiState() = MusicDetailsItemUiState(
    id = id,
    musicUrl = musicUrl,
    musicType = musicType,
    imagePath = imagePath,
)