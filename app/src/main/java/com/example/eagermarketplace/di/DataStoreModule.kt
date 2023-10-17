package com.example.eagermarketplace.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.eagermarketplace.data.repository.DataStoreRepository
import com.example.eagermarketplace.utils.Constants.STORE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


val Context.userPreferenceStore by preferencesDataStore(name = STORE_NAME)

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Provides
    @Singleton
    fun provideUserPreferenceStore(@ApplicationContext context: Context)
    = context.userPreferenceStore

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        userPreferenceStore: DataStore<Preferences>
    ) = DataStoreRepository((userPreferenceStore))
}