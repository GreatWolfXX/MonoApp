package com.greatwolf.monoapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.greatwolf.monoapp.data.dto.ExpenseCategoryItemDto

@Dao
interface ExpenseCategoryItemDao {

    @Query("SELECT * FROM expense_category_item")
    suspend fun getAllExpenseCategoryItem(): List<ExpenseCategoryItemDto>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expenseCategoryItem: ExpenseCategoryItemDto)

    @Update
    suspend fun update(expenseCategoryItem: ExpenseCategoryItemDto)

    @Delete
    suspend fun delete(expenseCategoryItem: ExpenseCategoryItemDto)

}