package com.greatwolf.monoapp.ui.screens.editCategoryScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greatwolf.monoapp.data.UiState
import com.greatwolf.monoapp.data.mappers.toExpenseDTO
import com.greatwolf.monoapp.data.mappers.toIncomeDTO
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.domain.useCase.db.GetAllExpenseCategoryItemUseCase
import com.greatwolf.monoapp.domain.useCase.db.GetAllIncomeCategoryItemUseCase
import com.greatwolf.monoapp.domain.useCase.db.InsertExpenseCategoryItemUseCase
import com.greatwolf.monoapp.domain.useCase.db.InsertIncomeCategoryItemUseCase
import com.greatwolf.monoapp.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditCategoryScreenViewModel @Inject constructor(
    private val insertExpense: InsertExpenseCategoryItemUseCase,
    private val insertIncome: InsertIncomeCategoryItemUseCase,
    private val getAllExpenseCategoryItem: GetAllExpenseCategoryItemUseCase,
    private val getAllIncomeCategoryItem: GetAllIncomeCategoryItemUseCase
) : ViewModel() {
    private val _ExpenseScreenState: MutableStateFlow<UiState<List<CategoryItem>>> =
        MutableStateFlow(UiState.Loading)

    private val _IncomeScreenState: MutableStateFlow<UiState<List<CategoryItem>>> =
        MutableStateFlow(UiState.Loading)

    val expenseState =_ExpenseScreenState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        initialValue = UiState.Loading
    )

    val incomeState =_IncomeScreenState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        initialValue = UiState.Loading
    )

    val isExpenseCategory = mutableStateOf<Boolean>(true)

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

    fun getExpenseList() {
        viewModelScope.launch {
            val response = getAllExpenseCategoryItem.invoke()
            handleGetExpenseListItemsResponse(response)
        }
    }

    private fun handleGetExpenseListItemsResponse(response: Result<List<CategoryItem>>) {
        when (response) {
            is Result.Success -> setExpenseScreenState(UiState.Success(response.data))
            is Result.Error -> setExpenseScreenState(UiState.Error(response.exception.message.toString()))
        }
    }

    private fun setExpenseScreenState(state: UiState<List<CategoryItem>>) {
        _ExpenseScreenState.update {
            state
        }
    }

    fun getIncomeList() {
        viewModelScope.launch {
            val response = getAllIncomeCategoryItem.invoke()
            handleGetIncomeListItemsResponse(response)
        }
    }

    private fun handleGetIncomeListItemsResponse(response: Result<List<CategoryItem>>) {
        when (response) {
            is Result.Success -> setIncomeScreenState(UiState.Success(response.data))
            is Result.Error -> setIncomeScreenState(UiState.Error(response.exception.message.toString()))
        }
    }

    private fun setIncomeScreenState(state: UiState<List<CategoryItem>>) {
        _IncomeScreenState.update {
            state
        }
    }
}