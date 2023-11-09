package com.example.eagermarketplace.di

import android.app.Application
import androidx.room.Room
import com.example.eagermarketplace.data.local.ItemDao
import com.example.eagermarketplace.data.local.ItemDb
import com.example.eagermarketplace.data.local.ItemRepository
import com.example.eagermarketplace.data.manager.LocalUserMangerImpl
import com.example.eagermarketplace.domain.manager.LocalUserManager
import com.example.eagermarketplace.domain.usecases.app_entry.AppEntryUseCases
import com.example.eagermarketplace.domain.usecases.app_entry.ReadAppEntry
import com.example.eagermarketplace.domain.usecases.app_entry.SaveAppEntry
import com.example.eagermarketplace.domain.usecases.item_usecases.DeleteItem
import com.example.eagermarketplace.domain.usecases.item_usecases.InsertItem
import com.example.eagermarketplace.domain.usecases.item_usecases.ItemsUseCases
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


    @Provides
    @Singleton
    fun providesItemRepository(itemDao: ItemDao): ItemRepository = ItemRepository(itemDao)


    @Provides
    @Singleton
    fun provideItemUseCase(
        itemRepository: ItemRepository,
        itemDao: ItemDao
    ): ItemsUseCases {
        return ItemsUseCases(
            deleteItem = DeleteItem(itemDao),
            insertItem = InsertItem(itemDao)
        )
    }

    @Provides
    @Singleton
    fun provideItemDatabase(
        application: Application
    ): ItemDb {
        return Room.databaseBuilder(
            context = application,
            klass = ItemDb::class.java,
            name = "ItemDb"
        ).fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideItemDao(
        itemDb: ItemDb
    ): ItemDao = itemDb.itemDao

}