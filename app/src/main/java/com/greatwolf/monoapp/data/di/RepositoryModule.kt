package com.greatwolf.monoapp.data.di

import com.greatwolf.monoapp.data.db.ExpenseCategoryItemDao
import com.greatwolf.monoapp.data.repository.ExpenseRepositoryImpl
import com.greatwolf.monoapp.domain.repository.ExpenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        categoryItemDao: ExpenseCategoryItemDao
    ): ExpenseRepository {
        return ExpenseRepositoryImpl(categoryItemDao)
    }

}