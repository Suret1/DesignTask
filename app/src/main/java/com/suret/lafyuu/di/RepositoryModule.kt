package com.suret.lafyuu.di

import com.suret.lafyuu.data.repository.LafyuuRepositoryImpl
import com.suret.lafyuu.data.repository.datasource.LocalDataSource
import com.suret.lafyuu.data.repository.datasource.RemoteDataSource
import com.suret.lafyuu.domain.repository.LafyuuRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): LafyuuRepository {
        return LafyuuRepositoryImpl(localDataSource, remoteDataSource)
    }
}