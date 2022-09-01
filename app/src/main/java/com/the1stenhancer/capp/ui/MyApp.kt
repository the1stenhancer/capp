package com.the1stenhancer.capp.ui


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.the1stenhancer.capp.ui.screen.CountryDetailScreen
import com.the1stenhancer.capp.ui.screen.CountryScreen
import com.the1stenhancer.capp.ui.screen.CountrySearchScreen
import com.the1stenhancer.capp.ui.screen.RegionScreen
import com.the1stenhancer.capp.viewmodel.PlanetViewModel


@Composable
fun MyApp(
    navController: NavHostController = rememberNavController(),
    planetViewModel: PlanetViewModel = hiltViewModel()
) {

    NavHost(navController = navController, startDestination = "regions") {
        navController.enableOnBackPressed(true)
        composable(
            route = "regions"
        ) {
            RegionScreen(
                viewModel = planetViewModel,
                onNavToCountryScreen = { region ->
                    planetViewModel.fetchCountries(region)
                    navController.navigate(route = "countries/$region") {
                        popUpTo("regions")
                    }
                }
            )
        }

        composable(
            route = "countries/{region}",
            arguments = listOf(navArgument("region") { type = NavType.StringType })
        ) {

            CountryScreen(
                region = it.arguments?.getString("region") as String,
                viewModel = planetViewModel,
                onNavToSearchScreen = {
                    navController.navigate("search")
                },
                onNavToDetailScreen = { country ->
                    planetViewModel.fetchCountries(country)
                    navController.navigate("detail/$country")
                }
            ) {
                navController.popBackStack()
            }
        }

        composable(
            route = "detail/{country}",
            arguments = listOf(navArgument("country") { type = NavType.StringType })
        ) {
            CountryDetailScreen(
                country = it.arguments?.getString("country") as String,
                viewModel = planetViewModel,
                onNavBackToCountryScreen = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = "search"
        ) {
            CountrySearchScreen(
                viewModel = planetViewModel,
                onNavToDetailScreen = { country ->
                    navController.navigate("detail/$country")
                },
                onNavToCountryScreen = {
                    navController.popBackStack()
                }
            )
        }
    }
}
