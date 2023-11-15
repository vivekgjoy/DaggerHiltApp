package com.mobil80.daggerhilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// @Module annotation which will make this class a module
// to inject dependency to other class within it's scope
// @InstallIn(SingletonComponent::class) this will make
// this class to inject dependencies across the entire application
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    // @Provides annotation along with this, we have used
    // @Singleton annotation so that whenever
    // we inject the dependency we inject the same
    // single instance of CryptocurrencyRepository were ever requested
    @Provides
    @Singleton
    fun provideCryptocurrencyRepository(): CryptocurrencyRepository=CryptocurrencyRepositoryImpl()

}