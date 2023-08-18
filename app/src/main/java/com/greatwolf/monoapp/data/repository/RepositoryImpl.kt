package com.greatwolf.monoapp.data.repository

import com.greatwolf.monoapp.data.db.CategoryItemDao
import com.greatwolf.monoapp.data.dto.CategoryItemDto
import com.greatwolf.monoapp.data.toDomain
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.domain.repository.Repository
import com.greatwolf.monoapp.domain.util.Result
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val categoryItemDao: CategoryItemDao
): Repository {
    override suspend fun getAllCategoryItem(): Result<List<CategoryItem>> {
        return try {
            Result.Success(categoryItemDao.getAllCategoryItem().toDomain())
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun insertCategoryItem(categoryItem: CategoryItemDto): Result<Unit> {
        return try {
            Result.Success(categoryItemDao.insert(categoryItem))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun deleteCategoryItem(categoryItem: CategoryItemDto): Result<Unit> {
        return try {
            Result.Success(categoryItemDao.delete(categoryItem))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun updateCategoryItem(categoryItem: CategoryItemDto): Result<Unit> {
        return try {
            Result.Success(categoryItemDao.update(categoryItem))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

}