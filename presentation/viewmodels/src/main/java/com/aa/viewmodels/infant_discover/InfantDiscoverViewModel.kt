package com.aa.viewmodels.infant_discover

import com.aa.base.BaseViewModel

class InfantDiscoverViewModel(): BaseViewModel<InfantDiscoverUiState>(InfantDiscoverUiState()) {

    init {
        getInfantDiscoverItems()
    }

    private fun getInfantDiscoverItems(){
        _state.value
    }
}