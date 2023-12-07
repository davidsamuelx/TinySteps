package com.aa.viewmodels.music

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.MusicEntity

data class MusicUiState(
    val musicList: List<MusicItemUiState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
): BaseUiState

data class MusicItemUiState(
    val id: Int = 0 ,
    val musicUrl: String = "" ,
    val musicType: String = "" ,
    val imagePath: String = "" ,
)

fun MusicEntity.toUiState() = MusicItemUiState(
    id = id,
    musicUrl = musicUrl,
    musicType = musicType,
    imagePath = imagePath,
)