package com.enes.kar.mvvm.di

import com.enes.kar.mvvm.data.local.AppPreferencesHelper
import com.enes.kar.mvvm.data.local.PreferencesHelper
import com.enes.kar.mvvm.data.remote.ApiService
import com.enes.kar.mvvm.ui.search.SearchRepo
import com.enes.kar.mvvm.ui.search.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by M.Enes on 4.06.2022.
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    internal fun provideSearchRepo(apiService: ApiService) = SearchRepository(apiService) as SearchRepo
}