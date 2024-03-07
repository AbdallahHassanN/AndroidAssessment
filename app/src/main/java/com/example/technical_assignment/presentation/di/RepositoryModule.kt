package com.example.technical_assignment.presentation.di


import android.content.Context
import com.example.technical_assignment.local.db.StoreItemDao
import com.example.technical_assignment.remote.network.ShopService
import com.example.technical_assignment.domain.repository.Repository
import com.example.technical_assignment.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        shopService: ShopService,
        @ApplicationContext appContext: Context, // Use @ApplicationContext to get the application context
        storeItemDao: StoreItemDao
    ): Repository {
        return RepositoryImpl(shopService,appContext,storeItemDao)
    }
}