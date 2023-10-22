package com.example.eagermarketplace.di

import android.app.Application
import com.example.eagermarketplace.data.manager.LocalUserMangerImpl
import com.example.eagermarketplace.domain.manager.LocalUserManager
import com.example.eagermarketplace.domain.usecases.app_entry.AppEntryUseCases
import com.example.eagermarketplace.domain.usecases.app_entry.ReadAppEntry
import com.example.eagermarketplace.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserMangerImpl(application)


    @Provides
    @Singleton
    fun provideEntryAppUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases (
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


}