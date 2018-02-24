package com.brainasaservice.android.customviewtesting.ui.mvp.accountview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.brainasaservice.android.customviewtesting.R
import com.brainasaservice.android.customviewtesting.ui.App
import kotlinx.android.synthetic.main.view_account.view.*

class AccountView(context: Context, attrs: AttributeSet) : AccountViewContract.View, LinearLayout(context, attrs) {

    private val presenter: AccountViewContract.Presenter by lazy {
        // simplicity first since this is not the focus
        (context.applicationContext as App).component.accountViewPresenter()
    }

    init {
        View.inflate(context, R.layout.view_account, this)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        presenter.onViewAttached(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.onViewDetached()
    }

    override fun setName(name: String) {
        nameText.text = name
    }

    override fun setLoggedOutName() {
        nameText.setText(R.string.account_name_logged_out)
    }

    override fun setLoggedOutAvatar() {
        avatarImage.setImageResource(android.R.drawable.ic_delete)
    }

    override fun setAvatar(imageResource: Int) {
        avatarImage.setImageResource(imageResource)
    }

    override fun showActivationMissingBadge() {
        badge.visibility = View.VISIBLE
        badge.setImageResource(android.R.drawable.radiobutton_off_background)
    }

    override fun showActivationPendingBadge() {
        badge.visibility = View.VISIBLE
        badge.setImageResource(android.R.drawable.radiobutton_on_background)
    }

    override fun hideBadge() {
        badge.visibility = View.GONE
    }

}

