package com.the1stenhancer.capp.utility


import com.squareup.moshi.Json


data class CountryName(
    @field:Json(name = "common") val common: String
)
