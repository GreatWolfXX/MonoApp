package com.greatwolf.monoapp.data.di

import com.greatwolf.monoapp.data.db.CategoryItemDao
import com.greatwolf.monoapp.data.repository.RepositoryImpl
import com.greatwolf.monoapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        categoryItemDao: CategoryItemDao
    ): Repository {
        return RepositoryImpl(categoryItemDao)
    }

}