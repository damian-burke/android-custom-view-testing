package com.brainasaservice.android.customviewtesting

import com.brainasaservice.android.customviewtesting.data.AccountDataSource
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {
    @Provides
    fun providesMockAccountDataSource(): AccountDataSource = MockAccountDataSource()
}
