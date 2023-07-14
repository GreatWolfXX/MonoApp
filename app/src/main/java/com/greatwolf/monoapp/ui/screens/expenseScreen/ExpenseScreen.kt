package com.greatwolf.monoapp.ui.screens.expenseScreen

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
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.ui.components.ButtonComponent
import com.greatwolf.monoapp.ui.components.CalendarSwitch
import com.greatwolf.monoapp.ui.components.CategoryList
import com.greatwolf.monoapp.ui.components.NoteInput
import com.greatwolf.monoapp.ui.components.PriceInput
import com.greatwolf.monoapp.ui.components.inputTopBar.InputNavGraph
import com.ramcosta.composedestinations.annotation.Destination

@InputNavGraph(start = true)
@Destination
@Composable
fun ExpenseScreen() {
    val categoryItemList = arrayListOf<CategoryItem>()
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
            NoteInput(title = stringResource(id = R.string.title_note))
        }
        Spacer(modifier = Modifier.size(24.dp))
        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryList(categoryItemList = categoryItemList)
            ButtonComponent(
                {},
                false,
                stringResource(id = R.string.title_submit)
            )
        }
    }
}