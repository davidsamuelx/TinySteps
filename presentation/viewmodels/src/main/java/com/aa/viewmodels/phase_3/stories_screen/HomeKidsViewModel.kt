package com.aa.viewmodels.phase_3.stories_screen

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseViewModel
import com.aa.models.kids.AllStoriesEntity
import com.aa.usecase.kids.AllStoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeKidsViewModel @Inject constructor(
    private val getAllStoriesUseCase: AllStoriesUseCase
) : BaseViewModel<HomeKidsUiState>(HomeKidsUiState()) {

    init {
        getAllStories()
    }

    private fun getAllStories() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { getAllStoriesUseCase() },
            ::onGetStoriesSuccess,
            ::onError
        )
    }

    private fun onGetStoriesSuccess(allStories: List<AllStoriesEntity>) {
        _state.update {
            it.copy(
                isLoading = false,
                storiesList = allStories.map { allStoriesEntity ->
                    allStoriesEntity.toUiState()
                }
            )
        }
    }

    private fun onError(errorUIState: BaseErrorUiState) {
        _state.update { it.copy(isLoading = false, error = errorUIState) }
    }

}