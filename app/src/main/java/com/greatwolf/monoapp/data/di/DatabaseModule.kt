package com.greatwolf.monoapp.data.di

import android.content.Context
import androidx.room.Room
import com.greatwolf.monoapp.data.db.ExpenseCategoryItemDao
import com.greatwolf.monoapp.data.db.AppDatabase
import com.greatwolf.monoapp.data.db.IncomeCategoryItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideExpenseCategoryItemDao(appDatabase: AppDatabase): ExpenseCategoryItemDao = appDatabase.expenseCategoryItemDao()

    @Provides
    fun provideIncomeCategoryItemDao(appDatabase: AppDatabase): IncomeCategoryItemDao = appDatabase.incomeCategoryItemDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "MonoAppDb"
        ).build()
    }
}