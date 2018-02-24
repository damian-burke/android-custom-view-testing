package com.brainasaservice.android.customviewtesting

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.brainasaservice.android.customviewtesting.model.Account
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AccountViewTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule<MockActivity>(MockActivity::class.java, true, false)

    @Before
    fun setup() {
        MockActivity.layout = R.layout.mock_view_account
    }

    @Test
    fun testLoggedOut() {
        MockAccountDataSource.account = loggedOutAccount
        restartActivity()

        onView(withId(R.id.nameText)).check(matches(withText(R.string.account_name_logged_out)))
        onView(withId(R.id.badge)).check(matches(not(isDisplayed())))
    }

    @Test
    fun testActivationPending() {
        MockAccountDataSource.account = accountActivationPending
        restartActivity()

        onView(withId(R.id.nameText)).check(matches(withText(accountActivationPending.name)))
        onView(withId(R.id.badge)).check(matches(isDisplayed()))
    }

    @Test
    fun testActivationMissing() {
        MockAccountDataSource.account = accountActivationMissing
        restartActivity()

        onView(withId(R.id.nameText)).check(matches(withText(accountActivationMissing.name)))
        onView(withId(R.id.badge)).check(matches(isDisplayed()))
    }

    @Test
    fun testActivationDone() {
        MockAccountDataSource.account = accountActivationDone
        restartActivity()

        onView(withId(R.id.nameText)).check(matches(withText(accountActivationDone.name)))
        onView(withId(R.id.badge)).check(matches(not(isDisplayed())))
    }

    private fun restartActivity() {
        if (activityRule.activity != null) {
            activityRule.finishActivity()
        }
        activityRule.launchActivity(Intent())
    }

    companion object {
        val loggedOutAccount = Account.LoggedOut
        val accountActivationPending = Account.Active("mock account", android.R.drawable.ic_delete, "pending")
        val accountActivationMissing = Account.Active("mock account", android.R.drawable.ic_delete, "missing")
        val accountActivationDone = Account.Active("mock account", android.R.drawable.ic_delete, "done")
    }
}
