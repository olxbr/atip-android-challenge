package com.olxbr.android.challenge.listing.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Listing(
    state: ListingState.Success,
    onAction: (ListingAction) -> Unit = {}
) {
    Column {
        TextField(
            value = state.query ?: "",
            onValueChange = {
                onAction(ListingAction.Filter(it))
            },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            label = { Text(text = "Pesquisar") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        LazyColumn {
            items(state.ads) { ad ->
                AdCard(ad)
            }
        }
    }
}
