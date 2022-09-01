package com.the1stenhancer.capp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.the1stenhancer.capp.data.repository.PlanetRepository
import com.the1stenhancer.capp.ui.state.CountryUiState
import com.the1stenhancer.capp.ui.state.RegionUiState
import com.the1stenhancer.capp.utility.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PlanetViewModel @Inject constructor(
    private val planetRepository: PlanetRepository
): ViewModel() {
    private val _regionScreenUiState = MutableStateFlow(RegionUiState())
    val regionScreenUiState: StateFlow<RegionUiState> = _regionScreenUiState

    private val _countryScreenUiState = MutableStateFlow(CountryUiState())
    val countryScreenUiState: StateFlow<CountryUiState> = _countryScreenUiState



    fun fetchRegions() {

        val regions = planetRepository.fetchRegions()
        _regionScreenUiState.update { currentUiState ->
            currentUiState.copy(
                regions = regions,
                loading = false
            )
        }
    }

    fun fetchCountries(entityName: String) {

        val result = planetRepository.fetchCountries(entityName)

        viewModelScope.launch {

            result.collect {
                if (it.success) {
                    _countryScreenUiState.value = CountryUiState(
                        countries =
                        result.value.countries.sortedBy { country -> country.name.common },
                        loading = false,
                        errorMessage = null
                    )
                } else if (it.error) {
                    _countryScreenUiState.value = CountryUiState(
                        loading = false,
                        errorMessage = "An error occurred!"
                    )
                }
            }
        }
    }


    fun resetCountryUiState() {
        _countryScreenUiState.update {
            it.copy(
                countries = emptyList(),
                loading = true,
                errorMessage = null
            )
        }
    }


    fun currentCountries(): List<Country> {
        return _countryScreenUiState.value.countries
    }

}