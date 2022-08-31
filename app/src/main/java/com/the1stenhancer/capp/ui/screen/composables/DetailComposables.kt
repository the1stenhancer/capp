package com.the1stenhancer.capp.ui.screen.composables


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.the1stenhancer.capp.R
import com.the1stenhancer.capp.ui.state.CountryUiState
import com.the1stenhancer.capp.utility.Item
import com.the1stenhancer.capp.utility.createDetailItems


@Composable
fun DetailContent(
    countryName: String,
    countryUiState: CountryUiState,
    paddingValues: PaddingValues
) {
    val countryInfo = countryUiState.countries
        .filter {
            it.name.common == countryName
        }[0]
        .createDetailItems()

    LazyColumn(
        contentPadding = paddingValues,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.grid_16))
    ) {
        item {
            TitleInfo()
        }
        items(countryInfo) { item ->
            ItemLine(item = item)
        }

    }
}


@Composable
fun TitleInfo() {
    Text(
        text = stringResource(id = R.string.basicInfo),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.grid_16))
    )

}


@Composable
fun ItemLine(
    item: Item<String, Any?>
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = dimensionResource(id = R.dimen.grid_8),
                horizontal = dimensionResource(id = R.dimen.grid_16)
            )
    ) {
        Text(
            text = item.key
        )
        Text(
            text = item.getValue(item.key).toString(),
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic,
            softWrap = true
        )
    }
}
