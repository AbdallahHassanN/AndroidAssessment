package com.example.technical_assignment.presentation.detailScreen


import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.technical_assignment.presentation.common.components.StoreItemView


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    title: String,
    desc: String,
    price: String,
    rating: String,
    img: String,
    count: String,
    navController: NavController
) {
    StoreItemView(
        title = title,
        desc = desc,
        price = price,
        rating = rating,
        img = img,
        count = count,
        navController = navController
    )
}


