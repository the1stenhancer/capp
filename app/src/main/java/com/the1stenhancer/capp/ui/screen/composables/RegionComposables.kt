package com.the1stenhancer.capp.ui.screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.the1stenhancer.capp.R
import com.the1stenhancer.capp.ui.state.RegionUiState
import com.the1stenhancer.capp.utility.Region



@Composable
fun RegionScreenContent(
    regionUiState: RegionUiState,
    paddingValues: PaddingValues,
    onNavToCountryScreen: (String) -> Unit
) {
    LazyColumn(contentPadding = paddingValues) {
        item {
            Welcome()
        }
        item {
            RegionTitle()
        }
        items(
            items = regionUiState.regions,
            key = { region -> region.id }
        ) { region ->
            RegionCard(region = region, onRegionCardClicked = { onNavToCountryScreen(region.name) })
        }
    }
}


@Composable
fun Welcome() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.grid_8),
                vertical = dimensionResource(id = R.dimen.grid_24)
            )
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.grid_150))
            .background(
                color = MaterialTheme.colors.secondary,
                shape = MaterialTheme.shapes.small
            )
    ) {
        Image(painter = painterResource(
            id = R.drawable.jetpack_compose),
            contentDescription = stringResource(id = R.string.compose_image),
            modifier = Modifier
                .size(dimensionResource(R.dimen.grid_120))
        )
        Text(
            text = stringResource(R.string.jetpackMessage),
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.grid_16))
        )
    }
}


@Composable
fun RegionTitle() {
    Text(
        text = stringResource(R.string.regionsTitle),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.grid_16))
    )
}


@Composable
fun RegionCard(
    region: Region,
    onRegionCardClicked: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .clickable { onRegionCardClicked(region.name) }
            .fillMaxWidth()
    ) {
        Text(
            text = region.name,
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