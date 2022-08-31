package com.the1stenhancer.capp.ui.state

import com.the1stenhancer.capp.utility.Region

data class RegionUiState(
    val regions: List<Region> = emptyList(),
    val loading: Boolean = true
)
