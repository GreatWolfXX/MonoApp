package com.greatwolf.monoapp.ui.screens.addCategoryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greatwolf.monoapp.data.mappers.toExpenseDTO
import com.greatwolf.monoapp.data.mappers.toIncomeDTO
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.domain.useCase.db.InsertExpenseCategoryItemUseCase
import com.greatwolf.monoapp.domain.useCase.db.InsertIncomeCategoryItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddCategoryScreenViewModel @Inject constructor(
    private val insertExpense: InsertExpenseCategoryItemUseCase,
    private val insertIncome: InsertIncomeCategoryItemUseCase,
) : ViewModel() {
    fun insertExpense(item: CategoryItem) {
        viewModelScope.launch {
            insertExpense.invoke(item.toExpenseDTO())
        }
    }

    fun insertIncome(item: CategoryItem) {
        viewModelScope.launch {
            insertIncome.invoke(item.toIncomeDTO())
        }
    }
}