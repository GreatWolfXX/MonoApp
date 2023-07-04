package com.greatwolf.monoapp.ui.components.bottomBar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.greatwolf.monoapp.R
import com.greatwolf.monoapp.ui.screens.destinations.CalculatorScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.InputScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.ReportScreenDestination
import com.greatwolf.monoapp.ui.screens.destinations.SettingsScreenDestination
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    @DrawableRes val icon: Int,
    @DrawableRes val iconSelected: Int,
    @StringRes val label: Int
) {
    Input(InputScreenDestination, R.drawable.input_ic, R.drawable.input_selected_ic, R.string.input_menu),
    Calculator(CalculatorScreenDestination, R.drawable.calculator_ic, R.drawable.calculator_selected_ic, R.string.calculator_menu),
    Report(ReportScreenDestination, R.drawable.report_ic, R.drawable.report_selected_ic, R.string.report_menu),
    Settings(SettingsScreenDestination, R.drawable.settings_ic, R.drawable.settings_selected_ic, R.string.settings_menu)
}