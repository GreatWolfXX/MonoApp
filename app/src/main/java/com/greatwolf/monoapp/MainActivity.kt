package com.greatwolf.monoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.greatwolf.monoapp.ui.components.bottomBar.BottomBar
import com.greatwolf.monoapp.ui.screens.NavGraphs
import com.greatwolf.monoapp.ui.screens.appCurrentDestinationAsState
import com.greatwolf.monoapp.ui.screens.destinations.AddCategoryScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.Destination
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
    val listScreensWithOutBottomBar =  listOf<Destination>(
        AddCategoryScreenDestination
    )

    Scaffold(
        bottomBar = {
            AnimatedContent(
                targetState = !listScreensWithOutBottomBar.contains(currentDestination),
                transitionSpec = {
                    if(targetState > initialState) {
                        slideInVertically { height -> height } togetherWith
                                slideOutVertically { height -> -height }
                    } else {
                        slideInVertically { height -> -height } togetherWith
                                slideOutVertically { height -> height }
                    }.using(
                        SizeTransform(clip = false)
                    )
                }, label = ""
            ) { isVisible ->
                if (isVisible) {
                    BottomBar(navController = navController)
                }
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