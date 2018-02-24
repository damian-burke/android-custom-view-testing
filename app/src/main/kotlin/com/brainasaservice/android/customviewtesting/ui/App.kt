package com.brainasaservice.android.customviewtesting.ui

import android.app.Application
import com.brainasaservice.android.customviewtesting.DataSourceModule
import com.brainasaservice.android.customviewtesting.di.AppComponent
import com.brainasaservice.android.customviewtesting.di.DaggerAppComponent
import com.brainasaservice.android.customviewtesting.di.PresenterModule

class App: Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .presenterModule(PresenterModule())
                .dataSourceModule(DataSourceModule())
                .build()
    }

}