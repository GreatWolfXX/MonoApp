package com.greatwolf.monoapp.domain.repository

import com.greatwolf.monoapp.data.dto.CategoryItemDto
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.domain.util.Result

interface Repository {

    suspend fun getAllCategoryItem() : Result<List<CategoryItem>>

    suspend fun insertCategoryItem(categoryItem: CategoryItemDto) : Result<Unit>

    suspend fun deleteCategoryItem(categoryItem: CategoryItemDto) : Result<Unit>

    suspend fun updateCategoryItem(categoryItem: CategoryItemDto) : Result<Unit>

}