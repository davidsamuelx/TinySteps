package com.aa.viewmodels.phase_3.stories_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.kids.AllStoriesEntity

data class HomeKidsUiState(
    val storiesList: List<StoriesItemUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class StoriesItemUiState(
    val id: Int,
    val title: String,
    val videoPath: String,
)

fun AllStoriesEntity.toUiState() = StoriesItemUiState(
    id = id,
    title = title,
    videoPath = pathVideo,
)