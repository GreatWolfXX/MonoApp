package com.greatwolf.monoapp.ui.screens.expenseScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.greatwolf.monoapp.data.UiState
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.ui.screens.expenseScreen.content.ExpenseSuccess
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun ExpenseScreen(
    viewModel: ExpenseScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues
) {

    val state = viewModel.expenseScreenState.collectAsState().value
    LaunchedEffect(Unit) {
        viewModel.getListGroupItems()
    }
    Column(
        Modifier.padding(paddingValues)
    ) {
        when (state) {
            is UiState.Success<List<CategoryItem>> -> {
                ExpenseSuccess(state.data, navigator)
            }

            is UiState.Loading -> {
                Log.d("GREATWOLF", "loading")
            }

            is UiState.Error -> {
                Log.d("GREATWOLF", "error ${state.errorMessage}")
            }

        }
    }
}