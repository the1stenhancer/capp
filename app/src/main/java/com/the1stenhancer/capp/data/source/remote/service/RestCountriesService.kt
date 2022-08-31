package com.the1stenhancer.capp.data.source.remote.service


import com.the1stenhancer.capp.utility.Country
import retrofit2.http.Path
import retrofit2.http.GET
import retrofit2.Call

interface RestCountriesService {

    @GET("region/{region}")
    fun fetchCountries(
        @Path(value = "region") region: String
    ): Call<List<Country>>

    @GET("name/{name}")
    fun fetchDetail(
        @Path(value = "name") name: String
    ): Call<List<Country>>

}