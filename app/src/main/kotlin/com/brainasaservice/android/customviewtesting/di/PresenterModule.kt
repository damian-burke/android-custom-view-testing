package com.brainasaservice.android.customviewtesting.di

import com.brainasaservice.android.customviewtesting.ui.mvp.accountview.AccountViewContract
import com.brainasaservice.android.customviewtesting.ui.mvp.accountview.AccountViewPresenter
import com.brainasaservice.android.customviewtesting.data.AccountDataSource
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
    @Provides
    fun providesAccountViewPresenter(dataSource: AccountDataSource): AccountViewContract.Presenter = AccountViewPresenter(dataSource)
}