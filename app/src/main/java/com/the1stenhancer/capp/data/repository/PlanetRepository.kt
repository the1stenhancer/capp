package com.the1stenhancer.capp.data.repository

import com.the1stenhancer.capp.data.source.local.RegionLocalSource
import com.the1stenhancer.capp.data.source.remote.CountryRemoteSource
import com.the1stenhancer.capp.utility.CountryResult
import com.the1stenhancer.capp.utility.Region
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class PlanetRepository @Inject constructor(
    private val regionLocalSource: RegionLocalSource,
    private val countryRemoteSource: CountryRemoteSource
) {

    fun fetchRegions(): List<Region> = regionLocalSource.fetchRegions()

    fun fetchCountries(entityName: String): MutableStateFlow<CountryResult> =
        countryRemoteSource.fetchCountries(entityName)

}