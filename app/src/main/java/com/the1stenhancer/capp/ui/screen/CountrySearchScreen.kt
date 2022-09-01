package com.the1stenhancer.capp.ui.screen


import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.the1stenhancer.capp.R
import com.the1stenhancer.capp.ui.screen.composables.CountrySearchResult
import com.the1stenhancer.capp.viewmodel.PlanetViewModel


@Composable
fun CountrySearchScreen(
    viewModel: PlanetViewModel,
    onNavToDetailScreen: (String) -> Unit,
    onNavToCountryScreen: () -> Unit
) {
    val allCountries = viewModel.currentCountries()
    var query by remember { mutableStateOf("") }
    var countryResultList by remember { mutableStateOf(allCountries) }
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    DisposableEffect(Unit) {
        focusRequester.requestFocus()
        onDispose { focusRequester.freeFocus() }
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.grid_8))
        ) {
            IconButton(
                onClick = onNavToCountryScreen
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.arrowBackToCountryScreen),
                    tint = MaterialTheme.colors.primary
                )
            }
            OutlinedTextField(
                value = query,
                onValueChange = {
                    query = it
                    countryResultList = if (query == "") {
                        allCountries
                    }
                    else {
                        allCountries.filter { country ->
                            country.name.common.contains(query, true)
                        }
                    }
                },
                shape = MaterialTheme.shapes.small,
                label = {
                    Text(
                        text = stringResource(id = R.string.search)
                    )
                },
                modifier = Modifier.focusRequester(focusRequester)
            )
        }
        CountrySearchResult(countries = countryResultList, navToDetailScreen = onNavToDetailScreen)
    }
}

//
//@Composable
//fun SearchBar(
//    query: String,
//    countries: List<Country>
//) {
//    val all = countries
//    var q = query
//    Row(
//        horizontalArrangement = Arrangement.Start,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(dimensionResource(id = R.dimen.grid_8))
//    ) {
//        IconButton(
//            onClick = {}
//        ) {
//            Icon(
//                imageVector = Icons.Filled.ArrowBack,
//                contentDescription = stringResource(id = R.string.arrowBackToCountryScreen)
//            )
//        }
//        OutlinedTextField(
//            value = query,
//            onValueChange = {
//                q = it
//                if (query.isEmpty())
//                    countries = all
//                else
//                    countries.filter { country ->
//                        country.name.common.contains(query)
//                    }
//            }
//        )
//    }
//}
