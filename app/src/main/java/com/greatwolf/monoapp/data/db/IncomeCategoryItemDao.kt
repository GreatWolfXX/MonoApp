package com.greatwolf.monoapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.greatwolf.monoapp.data.dto.ExpenseCategoryItemDto
import com.greatwolf.monoapp.data.dto.IncomeCategoryItemDto

@Dao
interface IncomeCategoryItemDao {

    @Query("SELECT * FROM income_category_item")
    suspend fun getAllIncomeCategoryItem(): List<IncomeCategoryItemDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(incomeCategoryItem: IncomeCategoryItemDto)

    @Update
    suspend fun update(incomeCategoryItem: IncomeCategoryItemDto)

    @Delete
    suspend fun delete(incomeCategoryItem: IncomeCategoryItemDto)

}