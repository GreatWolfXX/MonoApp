package com.greatwolf.monoapp.ui.screens.addCategoryScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.common.listOfDefaultIcons
import com.greatwolf.monoapp.ui.components.CategoryList
import com.greatwolf.monoapp.ui.components.TextInput
import com.greatwolf.monoapp.ui.components.TitleScreen
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun AddCategoryScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        TitleScreen(
            titleScreen = stringResource(id = R.string.title_add_category),
            additionalButtonText = stringResource(id = R.string.title_add)
        )

        TextInput(
            title = stringResource(id = R.string.title_category_name),
            placeholder = stringResource(id = R.string.title_placeholder),
            isContainsIcon = true
        )

        Spacer(modifier = Modifier.size(24.dp))
        
        CategoryList(
            categoryTitle = stringResource(id = R.string.title_icon),
            categoryItemList = listOfDefaultIcons,
            isCategoryContainsTitle = false,
            onClick = {}
        )
    }
}