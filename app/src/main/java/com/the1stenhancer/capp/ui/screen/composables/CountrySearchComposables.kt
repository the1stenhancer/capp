package com.the1stenhancer.capp.ui.screen.composables


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.the1stenhancer.capp.utility.Country


@Composable
fun CountrySearchResult(
    countries: List<Country>,
    navToDetailScreen: (String) -> Unit
) {
    LazyColumn {
        items(
            items = countries,
            key = { it.cca3 }
        ) {
            item -> CountryCard(
            country = item,
            onCountryCardClicked = { navToDetailScreen(item.name.common) }
        )
        }
    }
}
