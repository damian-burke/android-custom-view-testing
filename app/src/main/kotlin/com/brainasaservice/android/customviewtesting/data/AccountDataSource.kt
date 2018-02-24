package com.brainasaservice.android.customviewtesting.data

import com.brainasaservice.android.customviewtesting.model.Account

interface AccountDataSource {
    fun getAccount(): Account
}
