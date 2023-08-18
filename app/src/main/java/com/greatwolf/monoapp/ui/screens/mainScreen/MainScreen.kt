package com.greatwolf.monoapp.ui.screens.mainScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.greatwolf.monoapp.ui.components.bottomBar.BottomBar
import com.greatwolf.monoapp.ui.components.inputTopBar.InputTopBar
import com.greatwolf.monoapp.ui.screens.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@RootNavGraph(start = true)
@Destination
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { paddingValues ->
        DestinationsNavHost(
            modifier = Modifier.padding(paddingValues),
            navGraph = NavGraphs.bottomBar,
            navController = navController
        )
    }
}