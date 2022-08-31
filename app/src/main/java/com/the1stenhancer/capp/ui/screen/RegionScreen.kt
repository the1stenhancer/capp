package com.the1stenhancer.capp.ui.screen


import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.the1stenhancer.capp.R
import com.the1stenhancer.capp.ui.screen.composables.RegionCard
import com.the1stenhancer.capp.ui.screen.composables.RegionScreenContent
import com.the1stenhancer.capp.ui.screen.composables.RegionTitle
import com.the1stenhancer.capp.ui.screen.composables.Welcome
import com.the1stenhancer.capp.viewmodel.PlanetViewModel


@Composable
fun RegionScreen(
    viewModel: PlanetViewModel,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onNavToCountryScreen: (String) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground_2),
                        contentDescription = stringResource(id = R.string.app_logo),
                    )
                },
            )
        }
    ) {

        val regionScreenUiState = viewModel.regionScreenUiState.collectAsState()

        viewModel.fetchRegions()

        RegionScreenContent(
            regionUiState = regionScreenUiState.value,
            paddingValues = it,
            onNavToCountryScreen = onNavToCountryScreen
        )

    }
}
