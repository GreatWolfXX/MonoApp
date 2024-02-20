package com.greatwolf.monoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.greatwolf.monoapp.ui.components.bottomBar.BottomBar
import com.greatwolf.monoapp.ui.components.inputTopBar.InputTopBar
import com.greatwolf.monoapp.ui.screens.NavGraphs
import com.greatwolf.monoapp.ui.screens.appCurrentDestinationAsState
import com.greatwolf.monoapp.ui.screens.destinations.CalculatorScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.Destination
import com.greatwolf.monoapp.ui.screens.destinations.ExpenseScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.IncomeScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.InputScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.ReportScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.SettingsScreenDestination
import com.greatwolf.monoapp.ui.screens.startAppDestination
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
    val currentDestination: Destination = navController.appCurrentDestinationAsState().value
        ?: NavGraphs.root.startAppDestination
    val listScreensWithOutBottomBar =  listOf<Destination>()
    val listScreensWithTopBar =  listOf<Destination>(
        ExpenseScreenDestination,
        IncomeScreenDestination
    )
    Scaffold(
        bottomBar = {
            if(!listScreensWithOutBottomBar.contains(currentDestination)) {
                BottomBar(navController = navController)
            }
        },
        topBar = {
            if(listScreensWithTopBar.contains(currentDestination)) {
                InputTopBar(navController = navController)
            }
        }
    ) { paddingValues ->
        DestinationsNavHost(
            modifier = Modifier.padding(paddingValues),
            navGraph = NavGraphs.root,
            navController = navController
        )
    }
}