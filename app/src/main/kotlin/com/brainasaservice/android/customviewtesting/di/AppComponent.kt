package com.brainasaservice.android.customviewtesting.di

import com.brainasaservice.android.customviewtesting.DataSourceModule
import com.brainasaservice.android.customviewtesting.ui.accountview.AccountViewContract
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    PresenterModule::class,
    DataSourceModule::class
])
interface AppComponent {
    fun accountViewPresenter(): AccountViewContract.Presenter
}