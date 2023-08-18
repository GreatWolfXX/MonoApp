package com.greatwolf.monoapp.ui.screens.expenseScreen

import com.greatwolf.monoapp.domain.model.CategoryItem

sealed class ExpenseScreenState {
    object Loading: ExpenseScreenState()
    data class Success(val listOfCategoryItem: List<CategoryItem>): ExpenseScreenState()
    data class Error(val exception: Exception): ExpenseScreenState()
}