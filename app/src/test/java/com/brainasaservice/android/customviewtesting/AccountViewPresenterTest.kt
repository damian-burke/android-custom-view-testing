package com.brainasaservice.android.customviewtesting

import com.brainasaservice.android.customviewtesting.data.AccountDataSource
import com.brainasaservice.android.customviewtesting.model.Account
import com.brainasaservice.android.customviewtesting.ui.mvp.accountview.AccountViewContract
import com.brainasaservice.android.customviewtesting.ui.mvp.accountview.AccountViewPresenter
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@Suppress("IllegalIdentifier")
class AccountViewPresenterTest {

    @Mock
    lateinit var dataSource: AccountDataSource

    @Mock
    lateinit var account: Account.Active

    @Mock
    lateinit var view: AccountViewContract.View

    lateinit var presenter: AccountViewContract.Presenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        whenever(account.name).thenReturn(name)
        whenever(account.avatar).thenReturn(avatar)

        presenter = AccountViewPresenter(dataSource)
    }

    @Test
    fun `logged out account sets avatar`() {
        // given
        whenever(dataSource.getAccount()).thenReturn(Account.LoggedOut)

        // when
        presenter.onViewAttached(view)

        // then
        verify(view).setLoggedOutAvatar()
    }

    @Test
    fun `logged out account sets name`() {
        // given
        whenever(dataSource.getAccount()).thenReturn(Account.LoggedOut)

        // when
        presenter.onViewAttached(view)

        // then
        verify(view).setLoggedOutName()
    }

    @Test
    fun `logged out account hides badge`() {
        // given
        whenever(dataSource.getAccount()).thenReturn(Account.LoggedOut)

        // when
        presenter.onViewAttached(view)

        // then
        verify(view).hideBadge()
    }


    @Test
    fun `active account sets name`() {
        // given
        whenever(dataSource.getAccount()).thenReturn(account)
        whenever(account.activated).thenReturn("pending")
        // when
        presenter.onViewAttached(view)

        // then
        verify(view).setName(name)
    }

    @Test
    fun `active account sets avatar`() {
        // given
        whenever(dataSource.getAccount()).thenReturn(account)
        whenever(account.activated).thenReturn("pending")

        // when
        presenter.onViewAttached(view)

        // then
        verify(view).setAvatar(avatar)
    }

    @Test
    fun `active account with pending activation shows badge`() {
        // given
        whenever(dataSource.getAccount()).thenReturn(account)
        whenever(account.activated).thenReturn("pending")

        // when
        presenter.onViewAttached(view)

        // then
        verify(view).showActivationPendingBadge()
    }

    @Test
    fun `active account with finished activation hides badge`() {
        // given
        whenever(dataSource.getAccount()).thenReturn(account)
        whenever(account.activated).thenReturn("done")

        // when
        presenter.onViewAttached(view)

        // then
        verify(view).hideBadge()
    }

    @Test
    fun `active account with missing activation shows badge`() {
        // given
        whenever(dataSource.getAccount()).thenReturn(account)
        whenever(account.activated).thenReturn("missing")

        // when
        presenter.onViewAttached(view)

        // then
        verify(view).showActivationMissingBadge()
    }


    companion object {
        const val name = "user name"
        const val avatar = 12345
    }
}