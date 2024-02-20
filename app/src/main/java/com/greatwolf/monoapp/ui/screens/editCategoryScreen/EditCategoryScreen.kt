package com.greatwolf.monoapp.ui.screens.editCategoryScreen

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
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@Destination
@Composable
fun EditCategoryScreen() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        CategoryList(
            categoryTitle = stringResource(id = R.string.expense_menu),
            categoryItemList = listOfDefaultIcons,
            isCategoryContainsTitle = false,
            onClick = {},
            title = stringResource(id = R.string.title_add_more)
        )
        Spacer(modifier = Modifier.size(32.dp))
//        CategoryList(
//            categoryTitle = stringResource(id = R.string.income_menu),
//            categoryItemList = listOfDefaultIcons,
//            isCategoryContainsTitle = false,
//            onClick = {},
//            title = stringResource(id = R.string.title_add_more)
//        )
    }
}