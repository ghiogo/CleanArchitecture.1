package com.example.cleanarchitecture1.di

import com.example.data.repositories.UserDataRepositoryImpl
import com.example.domain.repositories.UserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindUserDataRepository(repositoryImpl: UserDataRepositoryImpl): UserDataRepository
}