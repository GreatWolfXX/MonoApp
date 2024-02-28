package com.greatwolf.monoapp.ui.screens.expenseScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.data.UiState
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.ui.components.ButtonComponent
import com.greatwolf.monoapp.ui.components.CalendarSwitch
import com.greatwolf.monoapp.ui.components.CategoryList
import com.greatwolf.monoapp.ui.components.PriceInput
import com.greatwolf.monoapp.ui.components.TextInput
import com.greatwolf.monoapp.ui.screens.destinations.AddCategoryScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.EditCategoryScreenDestination
import com.greatwolf.monoapp.ui.theme.Red
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ExpenseScreen(
    viewModel: ExpenseScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues
) {

    val state = viewModel.expenseScreenState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getListGroupItems()
    }
    ExpenseContent(
        state = state.value,
        viewModel = viewModel,
        navigator = navigator,
        paddingValues = paddingValues
    )
}

@Composable
private fun ExpenseContent(
    state: UiState<List<CategoryItem>>,
    viewModel: ExpenseScreenViewModel,
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues
) {
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

@Composable
private fun ExpenseSuccess(
    categoryItemList: List<CategoryItem>,
    navigator: DestinationsNavigator
) {
    val selectedItem = remember { mutableStateOf<CategoryItem?>(null) }
    val listOfExpenseIcons = ArrayList(categoryItemList)
    val text = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = Modifier
                .weight(0.8f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            CalendarSwitch({}, {}, "Feb 24, 2022 (Sat)")
            PriceInput(stringResource(id = R.string.expense_menu))
            TextInput(
                title = stringResource(id = R.string.title_note),
                text = text,
                placeholder = stringResource(id = R.string.title_placeholder),
                isContainsIcon = true
            )
        }
        Spacer(modifier = Modifier.size(24.dp))
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryList(
                selectedItem,
                titleLastButton = stringResource(id = R.string.title_edit),
                itemList = listOfExpenseIcons
            ) {
                navigator.navigate(EditCategoryScreenDestination)
            }
            ButtonComponent(
                {},
                false,
                stringResource(id = R.string.title_submit)
            )
        }
    }
}