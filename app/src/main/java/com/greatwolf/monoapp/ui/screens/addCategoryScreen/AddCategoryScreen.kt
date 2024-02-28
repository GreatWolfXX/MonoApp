package com.greatwolf.monoapp.ui.screens.addCategoryScreen

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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.common.listOfDefaultIcons
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.ui.components.CategoryList
import com.greatwolf.monoapp.ui.components.TextInput
import com.greatwolf.monoapp.ui.components.TitleScreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AddCategoryScreen(
    viewModel: AddCategoryScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val isAdditionalButtonActive = remember { mutableStateOf<Boolean>(false) }
    val selectedItem = remember { mutableStateOf<CategoryItem?>(null) }
    val selectedItemText = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp)
            .fillMaxHeight(),
    ) {
        isAdditionalButtonActive.value = selectedItemText.value.text.isNotEmpty() && selectedItem.value != null
        TitleScreen(
            titleScreen = stringResource(id = R.string.title_add_category),
            isAdditionalButtonActive = isAdditionalButtonActive,
            additionalButtonText = stringResource(id = R.string.title_add),
            navigator = navigator,
            additionalButtonOnClick = {
                if(isAdditionalButtonActive.value) {
                    selectedItem.value!!.string = selectedItemText.value.text
                    viewModel.insertIncome(selectedItem.value!!)
                    navigator.popBackStack()
                }
            }
        )

        TextInput(
            title = stringResource(id = R.string.title_category_name),
            text = selectedItemText,
            placeholder = stringResource(id = R.string.title_placeholder),
            isContainsIcon = false
        )

        Spacer(modifier = Modifier.size(24.dp))

        CategoryList(
            selectedItem,
            isIconChangedColor = true,
            isCategoryContainsTitle = false,
            isContainsLastButton = false,
            itemList = listOfDefaultIcons
        )
    }
}