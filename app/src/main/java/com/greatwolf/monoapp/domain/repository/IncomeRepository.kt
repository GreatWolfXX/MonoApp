package com.greatwolf.monoapp.domain.repository

import com.greatwolf.monoapp.data.dto.ExpenseCategoryItemDto
import com.greatwolf.monoapp.data.dto.IncomeCategoryItemDto
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.domain.util.Result

interface IncomeRepository {

    suspend fun getAllIncomeCategoryItem() : Result<List<CategoryItem>>

    suspend fun insertIncomeCategoryItem(categoryItem: IncomeCategoryItemDto) : Result<Unit>

    suspend fun deleteIncomeCategoryItem(categoryItem: IncomeCategoryItemDto) : Result<Unit>

    suspend fun updateIncomeCategoryItem(categoryItem: IncomeCategoryItemDto) : Result<Unit>

}