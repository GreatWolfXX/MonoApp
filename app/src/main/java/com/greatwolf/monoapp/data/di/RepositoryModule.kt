package com.greatwolf.monoapp.data.di

import com.greatwolf.monoapp.data.db.ExpenseCategoryItemDao
import com.greatwolf.monoapp.data.db.IncomeCategoryItemDao
import com.greatwolf.monoapp.data.repository.ExpenseRepositoryImpl
import com.greatwolf.monoapp.data.repository.IncomeRepositoryImpl
import com.greatwolf.monoapp.domain.repository.ExpenseRepository
import com.greatwolf.monoapp.domain.repository.IncomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideExpenseRepository(
        categoryItemDao: ExpenseCategoryItemDao
    ): ExpenseRepository {
        return ExpenseRepositoryImpl(categoryItemDao)
    }


    @Provides
    fun provideIncomeRepository(
        categoryItemDao: IncomeCategoryItemDao
    ): IncomeRepository {
        return IncomeRepositoryImpl(categoryItemDao)
    }

}