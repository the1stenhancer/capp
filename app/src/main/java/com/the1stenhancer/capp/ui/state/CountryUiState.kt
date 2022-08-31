package com.the1stenhancer.capp.ui.state

import com.the1stenhancer.capp.utility.Country

data class CountryUiState(
    val countries: List<Country> = emptyList(),
    val loading: Boolean = true,
    val errorMessage: String? = null
)
