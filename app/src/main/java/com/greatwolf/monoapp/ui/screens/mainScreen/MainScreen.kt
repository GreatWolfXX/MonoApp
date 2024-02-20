package com.greatwolf.monoapp.ui.screens.mainScreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.greatwolf.monoapp.ui.screens.NavGraphs
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen(navigator: DestinationsNavigator) {
    Scaffold { _ ->
        navigator.navigate(NavGraphs.bottomBar.route)
    }
}