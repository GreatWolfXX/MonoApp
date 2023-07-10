package com.greatwolf.monoapp.ui.screens.inputScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        },
        containerColor = MaterialTheme.colorScheme.surface
    ) { paddingValues ->
        DestinationsNavHost(
            modifier = Modifier.padding(paddingValues),
            navGraph = NavGraphs.input,
            navController = navController
        )
    }
}