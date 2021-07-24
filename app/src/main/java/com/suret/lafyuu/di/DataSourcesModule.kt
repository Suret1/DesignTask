package com.suret.lafyuu.di

import com.suret.lafyuu.data.api.AuthAPI
import com.suret.lafyuu.data.api.HomePageAPI
import com.suret.lafyuu.data.repository.datasource.LocalDataSource
import com.suret.lafyuu.data.repository.datasource.RemoteDataSource
import com.suret.lafyuu.data.repository.datasourceimpl.LocalDataSourceImpl
import com.suret.lafyuu.data.repository.datasourceimpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourcesModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(authAPI: AuthAPI, homePageAPI: HomePageAPI): RemoteDataSource {
        return RemoteDataSourceImpl(authAPI, homePageAPI)
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(): LocalDataSource {
        return LocalDataSourceImpl()
    }
}