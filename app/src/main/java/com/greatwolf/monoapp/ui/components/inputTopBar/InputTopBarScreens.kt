package com.greatwolf.monoapp.ui.components.inputTopBar

import androidx.annotation.StringRes
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.ui.theme.Expense
import com.greatwolf.monoapp.ui.theme.Income
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class InputTopBarScreens(
    @StringRes val label: Int,
    val selectedState: Boolean
) {
    Expense(R.string.expense_menu, true),
    Income(R.string.income_menu, false),
}