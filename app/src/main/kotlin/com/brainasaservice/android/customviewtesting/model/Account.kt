package com.brainasaservice.android.customviewtesting.model

sealed class Account {
    object LoggedOut: Account()

    data class Active(
            val name: String,
            val avatar: Int,
            val activated: String
    ): Account()
}
