package com.the1stenhancer.capp.data.source.local

import com.the1stenhancer.capp.utility.Region

class RegionLocalSource {
    fun fetchRegions(): List<Region> =
        listOf(
            Region(id = 1, name = "Africa"),
            Region(id = 2, name = "Americas"),
            Region(id = 3, name = "Asia"),
            Region(id = 4, name = "Europe"),
            Region(id = 5, name = "Oceania")
        )
}