package com.the1stenhancer.capp.ui.screen


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import com.the1stenhancer.capp.viewmodel.PlanetViewModel
import com.the1stenhancer.capp.R
import com.the1stenhancer.capp.ui.screen.composables.DetailContent


@Composable
fun CountryDetailScreen(
    country: String,
    viewModel: PlanetViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onNavBackToCountryScreen: () -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = country)
                },
                navigationIcon = {
                    IconButton(onClick = onNavBackToCountryScreen) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.arrowBackToCountryScreen)
                        )
                    }
                }
            )
        }
    ) {
        val countryUiState = viewModel.countryScreenUiState.collectAsState()
        DetailContent(
            countryName = country,
            countryUiState = countryUiState.value,
            paddingValues = it
        )
    }
}
