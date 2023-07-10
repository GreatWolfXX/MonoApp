package com.greatwolf.monoapp.ui.screens.expenseScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.ui.components.NoteInput
import com.greatwolf.monoapp.ui.components.PriceInput
import com.greatwolf.monoapp.ui.components.inputTopBar.InputNavGraph
import com.ramcosta.composedestinations.annotation.Destination

@InputNavGraph(start = true)
@Destination
@Composable
fun ExpenseScreen() {
//    CalendarSwitch({}, {}, "Feb 24, 2022 (Sat)")
//    PriceInput(stringResource(id = R.string.expense_menu))
    NoteInput(title = stringResource(id = R.string.title_note))
}