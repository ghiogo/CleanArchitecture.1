package com.example.cleanarchitecture1.di

import com.example.cleanarchitecture1.data.repositories.UserDataRepositoryImpl
import com.example.cleanarchitecture1.domain.repositories.UserDataRepository
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