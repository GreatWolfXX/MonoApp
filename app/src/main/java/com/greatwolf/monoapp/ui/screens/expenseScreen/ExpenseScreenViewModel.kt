package com.greatwolf.monoapp.ui.screens.expenseScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.domain.useCase.GetAllExpenseCategoryItemUseCase
import com.greatwolf.monoapp.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseScreenViewModel @Inject constructor(
    private val getAllCategoryItemUseCase: GetAllExpenseCategoryItemUseCase
) : ViewModel() {
    private val _ExpenseScreenState: MutableStateFlow<ExpenseScreenState> =
        MutableStateFlow(ExpenseScreenState.Loading)

    val expenseScreenState =_ExpenseScreenState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        initialValue = ExpenseScreenState.Loading
    )

    fun getListGroupItems() {
        viewModelScope.launch {
            val response = getAllCategoryItemUseCase.invoke()
            handleGetListCategoryItemsResponse(response)
        }
    }

    private fun handleGetListCategoryItemsResponse(response: Result<List<CategoryItem>>) {
        when (response) {
            is Result.Success -> setExpenseScreenState(ExpenseScreenState.Success(response.data))
            is Result.Error -> setExpenseScreenState(ExpenseScreenState.Error(response.exception))
        }
    }

    private fun setExpenseScreenState(state: ExpenseScreenState) {
        _ExpenseScreenState.update {
            state
        }
    }

}