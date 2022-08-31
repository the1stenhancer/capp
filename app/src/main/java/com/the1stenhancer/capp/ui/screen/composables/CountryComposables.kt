package com.the1stenhancer.capp.ui.screen.composables


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.the1stenhancer.capp.R
import com.the1stenhancer.capp.ui.state.CountryUiState
import com.the1stenhancer.capp.utility.Country


@Composable
fun CountryTitle() {
    Text(
        text = stringResource(R.string.countriesTitle),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.grid_16))
    )
}


@Composable
fun CountryCard(
    country: Country,
    onCountryCardClicked: (String) -> Unit,
) {

    Column(
        modifier = Modifier
            .clickable { onCountryCardClicked(country.name.common) }
            .fillMaxWidth()
    ) {
        Text(
            text = country.name.common,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.grid_16),
                    vertical = dimensionResource(id = R.dimen.grid_24)
                )
        )
        Divider()
    }
}


@Composable
fun CountryScreenContent(
    countryScreenUiState: CountryUiState,
    scaffoldState: ScaffoldState,
    paddingValues: PaddingValues,
    onNavToDetailScreen: (String) -> Unit
) {

    LazyColumn(contentPadding = paddingValues) {
        item {
            CountryTitle()
        }
        items(
            items = countryScreenUiState.countries,
            key = { country ->
                country.cca3
            }
        ) { country ->
            CountryCard(
                country = country,
                onCountryCardClicked = { onNavToDetailScreen(country.name.common) })
        }
    }
    // show snackbar in-case of an error
    if (countryScreenUiState.errorMessage != null) {
        LaunchedEffect(scaffoldState.snackbarHostState) {
            scaffoldState.snackbarHostState.showSnackbar(countryScreenUiState.errorMessage)
        }
    }
}

