package com.olxbr.android.challenge

import app.cash.turbine.test
import com.olxbr.android.challenge.listing.data.ListingService
import com.olxbr.android.challenge.listing.presentation.ListingAction
import com.olxbr.android.challenge.listing.presentation.ListingState
import com.olxbr.android.challenge.listing.presentation.ListingViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ListingViewModelTest {

    @Test
    fun shouldInitializeSuccessfully() = runTest {
        val service: ListingService = mockk()
        coEvery { service.getAds() } returns listOf()

        val viewModel = ListingViewModel(service)

        viewModel.state.test {
            assertEquals(ListingState.Uninitialized, awaitItem())
            viewModel.onAction(ListingAction.Initialize)
            assertEquals(ListingState.Success(listOf()), awaitItem())
        }
    }
}
