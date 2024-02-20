package com.greatwolf.monoapp.domain.repository

import com.greatwolf.monoapp.data.dto.ExpenseCategoryItemDto
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.domain.util.Result

interface ExpenseRepository {

    suspend fun getAllExpenseCategoryItem() : Result<List<CategoryItem>>

    suspend fun insertExpenseCategoryItem(categoryItem: ExpenseCategoryItemDto) : Result<Unit>

    suspend fun deleteExpenseCategoryItem(categoryItem: ExpenseCategoryItemDto) : Result<Unit>

    suspend fun updateExpenseCategoryItem(categoryItem: ExpenseCategoryItemDto) : Result<Unit>

}