package com.brainasaservice.android.customviewtesting

import com.brainasaservice.android.customviewtesting.data.AccountDataSource
import com.brainasaservice.android.customviewtesting.model.Account

/**
 * Our mock data source has the expected response as lateinit variable in a companion object,
 * which allows us to easily manipulate the response and thus trigger a state we're expecting.
 */
class MockAccountDataSource: AccountDataSource {
    override fun getAccount() = account

    companion object {
        lateinit var account: Account
    }
}
