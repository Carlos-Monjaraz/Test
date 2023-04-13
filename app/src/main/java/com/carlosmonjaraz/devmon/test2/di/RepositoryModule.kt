package com.carlosmonjaraz.devmon.test2.di

import com.carlosmonjaraz.devmon.test2.data.ProductRepositoryImpl
import com.carlosmonjaraz.devmon.test2.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTicketsRepository(ticketsRepository: ProductRepositoryImpl): ProductsRepository
}