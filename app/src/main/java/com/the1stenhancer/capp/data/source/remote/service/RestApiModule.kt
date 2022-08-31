package com.the1stenhancer.capp.data.source.remote.service


import com.the1stenhancer.capp.utility.Country
import com.the1stenhancer.capp.utility.CountryResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableStateFlow


const val BASE_URL = "https://restcountries.com/v3.1/"


@Module
@InstallIn(SingletonComponent::class)
object RestApiModule {

    @Provides
    fun providesRestCountriesApi(): RestCountriesService =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(RestCountriesService::class.java)

    @Provides
    fun providesCountryResult(): MutableStateFlow<CountryResult> =
        MutableStateFlow(
            CountryResult(
            countries = emptyList(),
            success = false,
            error = false
            )
        )
}