package com.the1stenhancer.capp.ui.screen


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.the1stenhancer.capp.viewmodel.PlanetViewModel
import com.the1stenhancer.capp.R
import com.the1stenhancer.capp.ui.screen.composables.CountryScreenContent
import com.the1stenhancer.capp.ui.state.CountryUiState


@Composable
fun CountryScreen(
    region: String,
    viewModel: PlanetViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onNavToDetailScreen: (String) -> Unit,
    onNavBackToRegionScreen: () -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = region
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavBackToRegionScreen) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.backToRegion)
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {  },
                backgroundColor = if (isSystemInDarkTheme()) {
                    MaterialTheme.colors.secondary
                } else {
                    MaterialTheme.colors.primary
                },
                contentColor = MaterialTheme.colors.onPrimary
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = stringResource(id = R.string.searchFAB)
                )
            }
        }
    ) {

        val countryScreenUiState = viewModel.countryScreenUiState.collectAsState()

        CountryScreenContent(
            countryScreenUiState = countryScreenUiState.value,
            scaffoldState = scaffoldState,
            paddingValues = it,
            onNavToDetailScreen = onNavToDetailScreen
        )

    }
}
