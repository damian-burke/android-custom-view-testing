package com.brainasaservice.android.customviewtesting.ui.accountview

import com.brainasaservice.android.customviewtesting.data.AccountDataSource
import com.brainasaservice.android.customviewtesting.model.Account

class AccountViewPresenter(
        private val accountDataSource: AccountDataSource
) : AccountViewContract.Presenter {

    private var view: AccountViewContract.View? = null

    override fun onViewAttached(view: AccountViewContract.View) {
        this.view = view
        val account = accountDataSource.getAccount()
        handleAccount(account)
    }

    private fun handleAccount(account: Account) {
        when (account) {
            Account.LoggedOut -> handleLoggedOut()
            is Account.Active -> {
                view?.setName(account.name)
                view?.setAvatar(account.avatar)
                handleAccountActivation(account.activated)
            }
        }
    }

    private fun handleLoggedOut() {
        view?.hideBadge()
        view?.setLoggedOutName()
        view?.setLoggedOutAvatar()
    }

    private fun handleAccountActivation(activation: String) = when (activation) {
        "done" -> view?.hideBadge()
        "missing" -> view?.showActivationMissingBadge()
        "pending" -> view?.showActivationPendingBadge()
        else -> throw IllegalStateException()
    }

    override fun onViewDetached() {
        // tear down, cancel subscriptions, etc...
    }
}
