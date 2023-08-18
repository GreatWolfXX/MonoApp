package com.greatwolf.monoapp.ui.screens.addCategoryScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.common.listOfDefaultIcons
import com.greatwolf.monoapp.ui.components.CategoryList
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
        CategoryList(
            categoryTitle = stringResource(id = R.string.title_icon),
            categoryItemList = listOfDefaultIcons,
            isCategoryContainsTitle = false
        )
    }
}