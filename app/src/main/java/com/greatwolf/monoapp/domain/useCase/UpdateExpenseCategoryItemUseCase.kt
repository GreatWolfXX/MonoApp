package com.greatwolf.monoapp.domain.useCase

import com.greatwolf.monoapp.data.dto.ExpenseCategoryItemDto
import com.greatwolf.monoapp.domain.repository.ExpenseRepository
import javax.inject.Inject

class UpdateExpenseCategoryItemUseCase @Inject constructor(
    private val repository: ExpenseRepository
){
    suspend operator fun invoke(categoryItem: ExpenseCategoryItemDto) = repository.updateExpenseCategoryItem(categoryItem)
}