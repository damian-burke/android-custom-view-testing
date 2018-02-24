package com.brainasaservice.android.customviewtesting

import com.brainasaservice.android.customviewtesting.data.AccountDataSource
import com.brainasaservice.android.customviewtesting.model.Account

/**
 * For simplicity, our "data source" will just return the account set in the constructor.
 */
class DumbAccountDataSource(val dumbAccount: Account): AccountDataSource {

    override fun getAccount(): Account = dumbAccount
}
