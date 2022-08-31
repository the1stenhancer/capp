package com.the1stenhancer.capp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.the1stenhancer.capp.ui.MyApp
import com.the1stenhancer.capp.ui.theme.CappTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        setDefaultKeyMode(DEFAULT_KEYS_SEARCH_LOCAL) // enables type-to-search func
        super.onCreate(savedInstanceState)
        setContent {
            CappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }

    private fun showSearchDialog(): () -> Unit {
        return { onSearchRequested() }
    }

    override fun onSearchRequested(): Boolean {
        return super.onSearchRequested()
    }
}
