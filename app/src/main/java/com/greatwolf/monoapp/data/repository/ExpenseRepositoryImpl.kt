package com.greatwolf.monoapp.data.repository

import com.greatwolf.monoapp.data.db.ExpenseCategoryItemDao
import com.greatwolf.monoapp.data.dto.ExpenseCategoryItemDto
import com.greatwolf.monoapp.data.mappers.toDomain
import com.greatwolf.monoapp.domain.model.CategoryItem
import com.greatwolf.monoapp.domain.repository.ExpenseRepository
import com.greatwolf.monoapp.domain.util.Result
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor (
    private val categoryItemDao: ExpenseCategoryItemDao
): ExpenseRepository {
    override suspend fun getAllExpenseCategoryItem(): Result<List<CategoryItem>> {
        return try {
            Result.Success(categoryItemDao.getAllExpenseCategoryItem().toDomain())
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun insertExpenseCategoryItem(categoryItem: ExpenseCategoryItemDto): Result<Unit> {
        return try {
            Result.Success(categoryItemDao.insert(categoryItem))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun deleteExpenseCategoryItem(categoryItem: ExpenseCategoryItemDto): Result<Unit> {
        return try {
            Result.Success(categoryItemDao.delete(categoryItem))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    override suspend fun updateExpenseCategoryItem(categoryItem: ExpenseCategoryItemDto): Result<Unit> {
        return try {
            Result.Success(categoryItemDao.update(categoryItem))
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

}