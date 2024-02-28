package com.greatwolf.monoapp.ui.screens.editCategoryScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.data.UiState
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.ui.components.CategoryList
import com.greatwolf.monoapp.ui.components.TitleScreen
import com.greatwolf.monoapp.ui.screens.destinations.AddCategoryScreenDestination
import com.greatwolf.monoapp.ui.theme.Red
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph
@Destination
@Composable
fun EditCategoryScreen(
    viewModel: EditCategoryScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val isAdditionalButtonActive = remember { mutableStateOf<Boolean>(false) }
    val selectedItem = remember { mutableStateOf<CategoryItem?>(null) }

    val stateExpense = viewModel.expenseState.collectAsState().value
    val stateIncome = viewModel.incomeState.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.getExpenseList()
        viewModel.getIncomeList()
    }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp)
            .fillMaxHeight(),
    ) {
        TitleScreen(
            titleScreen = stringResource(id = R.string.title_edit_category),
            isAdditionalButtonActive = isAdditionalButtonActive,
            additionalButtonColor = Red,
            additionalButtonText = stringResource(id = R.string.title_remove),
            navigator = navigator,
            additionalButtonOnClick = {

            }
        )
        when (stateExpense) {
            is UiState.Success<List<CategoryItem>> -> {
                Log.d("GREATWOLF", "success expense ${stateExpense.data}")
                CategoryList(
                    titleList = stringResource(id = R.string.expense_menu),
                    selectedItem,
                    selectedColor = Red,
                    titleLastButton = stringResource(id = R.string.title_add_more),
                    itemList = ArrayList(stateExpense.data)
                ) {
                    viewModel.isExpenseCategory.value = true
                    navigator.navigate(AddCategoryScreenDestination(true))
                }
            }

            is UiState.Loading -> {
                Log.d("GREATWOLF", "loading")
            }

            is UiState.Error -> {
                Log.d("GREATWOLF", "error ${stateExpense.errorMessage}")
            }
        }
        Spacer(modifier = Modifier.size(40.dp))
        when (stateIncome) {
            is UiState.Success<List<CategoryItem>> -> {
                Log.d("GREATWOLF", "success income ${stateIncome.data}")
                CategoryList(
                    titleList = stringResource(id = R.string.income_menu),
                    selectedItem,
                    selectedColor = Red,
                    titleLastButton = stringResource(id = R.string.title_add_more),
                    itemList = ArrayList(stateIncome.data)
                ) {
                    viewModel.isExpenseCategory.value = false
                    navigator.navigate(AddCategoryScreenDestination(false))
                }
            }

            is UiState.Loading -> {
                Log.d("GREATWOLF", "loading")
            }

            is UiState.Error -> {
                Log.d("GREATWOLF", "error ${stateIncome.errorMessage}")
            }
        }
    }
}