package com.olxbr.android.challenge.listing.data

import com.olxbr.android.challenge.listing.model.Ad
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListingService {

    suspend fun getAds(): List<Ad> {
        return withContext(Dispatchers.IO) {
            localAds
        }
    }
}
