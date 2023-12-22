package com.aa.viewmodels.phase_3.kids_discover

import com.aa.base.BaseViewModel

class KidsDiscoverViewModel(): BaseViewModel<KidsDiscoverUiState>(KidsDiscoverUiState()) {

    init {
        getKidsDiscoverItems()
    }

    private fun getKidsDiscoverItems(){
        _state.value
    }
}