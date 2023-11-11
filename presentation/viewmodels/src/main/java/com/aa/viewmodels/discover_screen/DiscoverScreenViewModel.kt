package com.aa.viewmodels.discover_screen

import com.aa.base.BaseViewModel

class DiscoverScreenViewModel ():BaseViewModel<DiscoverScreenUiState>(DiscoverScreenUiState()){

    init {
        getDiscoverItems()
    }

    private fun getDiscoverItems(){
        _state.value
    }
}