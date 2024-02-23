package com.greatwolf.monoapp.domain.useCase.db

import com.greatwolf.monoapp.domain.repository.ExpenseRepository
import javax.inject.Inject

class GetAllExpenseCategoryItemUseCase @Inject constructor(
    private val repository: ExpenseRepository
){
    suspend operator fun invoke() = repository.getAllExpenseCategoryItem()
}