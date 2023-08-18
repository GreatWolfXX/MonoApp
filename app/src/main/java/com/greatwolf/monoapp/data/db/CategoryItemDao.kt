package com.greatwolf.monoapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.greatwolf.monoapp.data.dto.CategoryItemDto

@Dao
interface CategoryItemDao {

    @Query("SELECT * FROM default_icons")
    suspend fun getAllCategoryItem(): List<CategoryItemDto>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(defaultIcon: CategoryItemDto)

    @Update
    suspend fun update(defaultIcon: CategoryItemDto)

    @Delete
    suspend fun delete(defaultIcon: CategoryItemDto)

}