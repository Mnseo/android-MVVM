package com.minseo.data.di

import android.content.Context
import com.minseo.data.local.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DataStoreModule {
    @Singleton
    @Provides
    fun dataStore(@ApplicationContext context: Context): DataStoreManager =
        DataStoreManager(context)
}