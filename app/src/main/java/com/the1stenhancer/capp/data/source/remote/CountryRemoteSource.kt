package com.the1stenhancer.capp.data.source.remote

import com.the1stenhancer.capp.data.source.remote.service.RestCountriesService
import com.the1stenhancer.capp.utility.Country
import com.the1stenhancer.capp.utility.CountryResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CountryRemoteSource @Inject constructor(
    private val restCountriesService: RestCountriesService,
    private val countryList: MutableStateFlow<CountryResult>
) {
    fun fetchCountries(region: String): MutableStateFlow<CountryResult> {
        val call = restCountriesService.fetchCountries(region)

        call.enqueue(
            object: Callback<List<Country>> {
                override fun onFailure(
                    call: Call<List<Country>>,
                    t: Throwable
                ) {
                    /**
                     * Nothing happens since default success is false
                     */
                    countryList.value = CountryResult(
                        countries = emptyList(),
                        success = false,
                        error = true
                    )
                }

                override fun onResponse(
                    call: Call<List<Country>>,
                    response: Response<List<Country>>
                ) {
                    if (response.isSuccessful) {
                        val countries = response.body()
                        if (countries != null) {
                            countryList.value = CountryResult(
                                countries = countries,
                                success = true,
                                error = false
                            )
                        }
                    }
                }
            }
        )
        return countryList
    }


//    fun fetchDetail(country: String): CountryResult {
//        val call = restCountriesService.fetchDetail(country)
//        call.enqueue(
//            object: Callback<List<Country>> {
//                override fun onFailure(
//                    call: Call<List<Country>>,
//                    t: Throwable
//                ) {
//                    /**
//                     * Nothing happens since default success is false
//                     */
//                }
//
//                override fun onResponse(
//                    call: Call<List<Country>>,
//                    response: Response<List<Country>>
//                ) {
//                    if (response.isSuccessful) {
//                        val countries = response.body()
//                        if (countries != null) {
//                            countryList.countries = countries
//                            countryList.success = true
//                        }
//                    }
//                }
//            }
//        )
//        return countryList
//    }
}