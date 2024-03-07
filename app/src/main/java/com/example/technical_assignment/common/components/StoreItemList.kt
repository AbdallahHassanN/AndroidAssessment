package com.example.technical_assignment.common.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
        ) {
            itemsIndexed(
                items = storeItems ?: emptyList()
            ) { _, item ->
                GridItemCard(
                    item = item,
                    onClick = {
                        val encodedImg =
                            URLEncoder
                                .encode(item.image, "UTF-8")
                                .toString().trimEnd()
                        val encodedDesc =
                            URLEncoder
                                .encode(item.description, "UTF-8")
                                .toString().replace("+", " ")
                        val encodedTitle =
                            URLEncoder
                                .encode(item.title, "UTF-8")
                                .toString().replace("+", " ")
                        navController.navigate(
                            Screens.DetailScreen.withArgs(
                                encodedTitle,
                                encodedDesc,
                                item.price.toString(),
                                item.rating.rate.toString(),
                                encodedImg,
                                item.rating.count.toString()
                            )
                        )
                    }
                )
            }
        }
    }
}