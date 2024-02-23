package com.greatwolf.monoapp.ui.screens.inputScreen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.greatwolf.monoapp.ui.components.inputTopBar.InputTopBar
import com.greatwolf.monoapp.ui.screens.expenseScreen.ExpenseScreen
import com.greatwolf.monoapp.ui.screens.mainScreen.BottomBarNavGraph
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@BottomBarNavGraph(start = true)
@Destination
@Composable
fun InputScreen(
    navigator: DestinationsNavigator
) {
    val isExpense = remember { mutableStateOf(true) }
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            InputTopBar(isExpense)
        }
    ) { paddingValues ->
        if(isExpense.value) {
            ExpenseScreen(
                navigator = navigator,
                paddingValues = paddingValues
            )
        }
    }
}