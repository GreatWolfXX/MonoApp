package com.greatwolf.monoapp.ui.screens.expenseScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.ui.components.ButtonComponent
import com.greatwolf.monoapp.ui.components.CalendarSwitch
import com.greatwolf.monoapp.ui.components.CategoryList
import com.greatwolf.monoapp.ui.components.PriceInput
import com.greatwolf.monoapp.ui.components.TextInput
import com.greatwolf.monoapp.ui.components.inputTopBar.InputNavGraph
import com.greatwolf.monoapp.ui.screens.destinations.AddCategoryScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@InputNavGraph(start = true)
@Destination
@Composable
fun ExpenseScreen(
    viewModel: ExpenseScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state = viewModel.expenseScreenState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getListGroupItems()
    }
    ExpenseContent(
        state = state.value,
        viewModel = viewModel,
        navigator = navigator
    )
}

@Composable
private fun ExpenseContent(
    state: ExpenseScreenState,
    viewModel: ExpenseScreenViewModel,
    navigator: DestinationsNavigator
) {
    Column {
        when (state) {
            is ExpenseScreenState.Success -> {
                ExpenseSuccess(state.listOfCategoryItem, navigator)
            }

            is ExpenseScreenState.Loading -> {
                Log.d("GREATWOLF", "loading")
            }

            is ExpenseScreenState.Error -> {
                Log.d("GREATWOLF", "error ${state.exception}")
            }

        }
    }
}

@Composable
private fun ExpenseSuccess(
    categoryItemList: List<CategoryItem>,
    navigator: DestinationsNavigator
) {

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
                categoryTitle = stringResource(id = R.string.title_category),
                categoryItemList = ArrayList(categoryItemList),
                onClick = {
                    navigator.navigate(AddCategoryScreenDestination)
                },
                title = stringResource(id = R.string.title_edit)
            )
            ButtonComponent(
                {},
                false,
                stringResource(id = R.string.title_submit)
            )
        }

//        CategoryList(
//            categoryTitle = stringResource(id = R.string.title_icon),
//            categoryItemList = listOfDefaultIcons,
//            isCategoryContainsTitle = false
//        )
    }
}