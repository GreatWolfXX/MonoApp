package com.greatwolf.monoapp.ui.components.inputTopBar

import androidx.annotation.StringRes
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.ui.screens.destinations.ExpenseScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.IncomeScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class InputTopBarDestination(
    val direction: DirectionDestinationSpec,
    @StringRes val label: Int
) {
    Expense(ExpenseScreenDestination, R.string.expense_menu),
    Income(IncomeScreenDestination,  R.string.income_menu),
}