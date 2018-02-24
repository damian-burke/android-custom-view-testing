package com.brainasaservice.android.customviewtesting.ui.mvp.accountview

import com.brainasaservice.android.customviewtesting.ui.mvp.BaseContract

interface AccountViewContract {
    interface View: BaseContract.View {
        fun setLoggedOutName()
        fun setLoggedOutAvatar()

        fun setName(name: String)

        fun setAvatar(imageResource: Int)
        fun showActivationMissingBadge()
        fun showActivationPendingBadge()
        fun hideBadge()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun onViewAttached(view: View)
        fun onViewDetached()
    }
}
