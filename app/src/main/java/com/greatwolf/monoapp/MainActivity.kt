package com.greatwolf.monoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.greatwolf.monoapp.ui.components.bottomBar.BottomBar
import com.greatwolf.monoapp.ui.screens.NavGraphs
import com.greatwolf.monoapp.ui.theme.MonoAppTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    AppInit()
                }
            }
        }
    }
}

@Composable
private fun AppInit() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
           BottomBar(navController = navController)
        }
    ) { _ ->
        DestinationsNavHost(
            navGraph = NavGraphs.root,
            navController = navController
        )
    }
}