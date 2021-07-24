package com.suret.lafyuu.di

import com.suret.lafyuu.domain.repository.LafyuuRepository
import com.suret.lafyuu.domain.usecase.GetHomeListUseCase
import com.suret.lafyuu.domain.usecase.LoginUseCase
import com.suret.lafyuu.domain.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideLoginUseCase(lafyuuRepository: LafyuuRepository): LoginUseCase {
        return LoginUseCase(lafyuuRepository)
    }

    @Singleton
    @Provides
    fun provideRegisterUseCase(lafyuuRepository: LafyuuRepository): RegisterUseCase {
        return RegisterUseCase(lafyuuRepository)
    }

    @Singleton
    @Provides
    fun provideGetHomeListUseCase(lafyuuRepository: LafyuuRepository): GetHomeListUseCase {
        return GetHomeListUseCase(lafyuuRepository)
    }
}