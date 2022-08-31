package com.the1stenhancer.capp.utility


import com.squareup.moshi.Json


data class Country(
    @field:Json(name = "name") val name: CountryName,
    @field:Json(name = "cca3") val cca3: String,
    @field:Json(name = "subregion") val subRegion: String,
    @field:Json(name = "independent") val independent: Boolean
)
