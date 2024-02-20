package com.greatwolf.monoapp.ui.screens.inputScreen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.greatwolf.monoapp.ui.components.bottomBar.BottomBarNavGraph
import com.greatwolf.monoapp.ui.screens.NavGraphs
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@BottomBarNavGraph(start = true)
@Destination
@Composable
fun InputScreen(navigator: DestinationsNavigator) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface
    ) { _ ->
        navigator.navigate(NavGraphs.input.route)
    }
}