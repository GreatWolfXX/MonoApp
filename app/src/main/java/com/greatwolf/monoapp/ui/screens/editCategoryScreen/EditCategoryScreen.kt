package com.greatwolf.monoapp.ui.screens.editCategoryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.greatwolf.monoapp.R
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
    navigator: DestinationsNavigator
) {
    val isAdditionalButtonActive = remember { mutableStateOf<Boolean>(false) }
    val selectedItem = remember { mutableStateOf<CategoryItem?>(null) }
    val listOfExpenseIcons = arrayListOf<CategoryItem>()
    val listOfIncomeIcons = arrayListOf<CategoryItem>()

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
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

        CategoryList(
            selectedItem,
            selectedColor = Red,
            titleLastButton = stringResource(id = R.string.title_add_category),
            itemList = listOfExpenseIcons
        ) {
            navigator.navigate(AddCategoryScreenDestination)
        }

        Spacer(modifier = Modifier.size(40.dp))

        CategoryList(
            selectedItem,
            selectedColor = Red,
            titleLastButton = stringResource(id = R.string.title_add_category),
            itemList = listOfIncomeIcons
        ) {
            navigator.navigate(AddCategoryScreenDestination)
        }
    }
}