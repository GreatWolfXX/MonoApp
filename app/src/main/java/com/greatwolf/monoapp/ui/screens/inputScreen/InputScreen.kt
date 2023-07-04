package com.greatwolf.monoapp.ui.screens.inputScreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.greatwolf.monoapp.ui.components.inputTopBar.InputTopBar
import com.greatwolf.monoapp.ui.screens.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun InputScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            InputTopBar(navController = navController)
        }
    ) { _ ->
        DestinationsNavHost(
            navGraph = NavGraphs.input,
            navController = navController
        )
    }
}