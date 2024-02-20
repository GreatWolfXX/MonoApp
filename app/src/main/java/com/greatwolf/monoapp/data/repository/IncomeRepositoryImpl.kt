package com.greatwolf.monoapp.data.repository

import com.greatwolf.monoapp.data.db.IncomeCategoryItemDao
import com.greatwolf.monoapp.data.dto.IncomeCategoryItemDto
import com.greatwolf.monoapp.data.mappers.toDomain
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.domain.repository.IncomeRepository
import com.greatwolf.monoapp.domain.util.Result
import javax.inject.Inject

class IncomeRepositoryImpl @Inject constructor (
    private val categoryItemDao: IncomeCategoryItemDao
): IncomeRepository {
    override suspend fun getAllIncomeCategoryItem(): Result<List<CategoryItem>> {
        return try {
            Result.Success(categoryItemDao.getAllIncomeCategoryItem().toDomain())
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun insertIncomeCategoryItem(categoryItem: IncomeCategoryItemDto): Result<Unit> {
        return try {
            Result.Success(categoryItemDao.insert(categoryItem))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun deleteIncomeCategoryItem(categoryItem: IncomeCategoryItemDto): Result<Unit> {
        return try {
            Result.Success(categoryItemDao.delete(categoryItem))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun updateIncomeCategoryItem(categoryItem: IncomeCategoryItemDto): Result<Unit> {
        return try {
            Result.Success(categoryItemDao.update(categoryItem))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

}