package com.example.technical_assignment.presentation.detailScreen


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.technical_assignment.common.Constants.TAG
import com.example.technical_assignment.common.components.StoreItemView


@Composable
fun DetailScreen(
    title: String,
    desc: String,
    price: String,
    rating: String,
    img: String,
    count: String
) {
    Log.d(TAG, title)
    Log.d(TAG, desc)
    Log.d(TAG, price)
    Log.d(TAG, rating)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        StoreItemView(
            title, desc, price, rating, img, count
        )
    }

}


