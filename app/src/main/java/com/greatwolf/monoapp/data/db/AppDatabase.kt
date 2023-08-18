package com.greatwolf.monoapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.greatwolf.monoapp.data.dto.CategoryItemDto

@Database(entities = [CategoryItemDto::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun  categoryItemDao(): CategoryItemDao
}