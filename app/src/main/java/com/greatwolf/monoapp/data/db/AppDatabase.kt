package com.greatwolf.monoapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.greatwolf.monoapp.data.dto.ExpenseCategoryItemDto
import com.greatwolf.monoapp.data.dto.IncomeCategoryItemDto

@Database(entities = [
    ExpenseCategoryItemDto::class,
    IncomeCategoryItemDto::class
                     ], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun  expenseCategoryItemDao(): ExpenseCategoryItemDao
    abstract fun  incomeCategoryItemDao(): IncomeCategoryItemDao
}