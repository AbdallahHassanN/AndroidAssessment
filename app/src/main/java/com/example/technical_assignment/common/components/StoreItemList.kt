package com.example.technical_assignment.common.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.technical_assignment.common.CircularProgressBar
import com.example.technical_assignment.models.StoreItem
import com.example.technical_assignment.navigation.Screens
import java.net.URLEncoder

@Composable
fun StoreItemList(
    loading: Boolean,
    storeItems: List<StoreItem>?,
    it: PaddingValues,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(it)
    ) {
        CircularProgressBar(isDisplayed = loading)
        LazyColumn {
            itemsIndexed(
                items = storeItems!!
            ) { _, storeItem ->
                StoreItemCard(storeItem = storeItem, onClick = {
                    val encoded = URLEncoder.encode(storeItem.image, "UTF-8").toString()
                    navController.navigate(
                        Screens.DetailScreen.withArgs(
                            storeItem.title,
                            storeItem.description,
                            storeItem.price.toString(),
                            storeItem.rating.rate.toString(),
                            encoded,
                            storeItem.rating.count.toString()
                        )
                    )
                })
            }
        }
    }
}