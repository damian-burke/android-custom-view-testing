package com.brainasaservice.android.customviewtesting

import com.brainasaservice.android.customviewtesting.data.AccountDataSource
import com.brainasaservice.android.customviewtesting.model.Account
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {

    /**
     * For simplicity, our example simply returns Logged Out in our production state.
     */
    @Provides
    fun providesMockAccountDataSource(): AccountDataSource = DumbAccountDataSource(Account.LoggedOut)
}
