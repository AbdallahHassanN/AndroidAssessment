package com.example.technical_assignment.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.technical_assignment.common.Constants.ITEM_COUNT
import com.example.technical_assignment.common.Constants.ITEM_DESC
import com.example.technical_assignment.presentation.detailScreen.DetailScreen
import com.example.technical_assignment.common.Constants.ITEM_IMG
import com.example.technical_assignment.common.Constants.ITEM_PRICE
import com.example.technical_assignment.common.Constants.ITEM_RATING
import com.example.technical_assignment.common.Constants.ITEM_TITLE
import com.example.technical_assignment.presentation.mainScreen.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screens.DetailScreen.route +
                    "/{${ITEM_TITLE}}" +
                    "/{${ITEM_DESC}}" +
                    "/{${ITEM_PRICE}}" +
                    "/{${ITEM_RATING}}" +
                    "/{${ITEM_IMG}}" +
                    "/{${ITEM_COUNT}}"

            ,arguments = listOf(
                navArgument(ITEM_TITLE) {
                    type = NavType.StringType
                }, navArgument(ITEM_DESC) {
                    type = NavType.StringType
                }, navArgument(ITEM_PRICE) {
                    type = NavType.StringType
                }, navArgument(ITEM_RATING) {
                    type = NavType.StringType
                }, navArgument(ITEM_IMG) {
                    type = NavType.StringType
                }, navArgument(ITEM_COUNT) {
                    type = NavType.StringType
                }

            )) {
            val itemDesc = it.arguments?.getString(ITEM_DESC)
            val itemTitle = it.arguments?.getString(ITEM_TITLE)
            val itemPrice = it.arguments?.getString(ITEM_PRICE)
            val itemRating = it.arguments?.getString(ITEM_RATING)
            val itemIMG = it.arguments?.getString(ITEM_IMG)
            val itemCOUNT = it.arguments?.getString(ITEM_COUNT)

            if (
                itemTitle != null &&
                itemDesc != null &&
                itemPrice != null &&
                itemRating != null &&
                itemIMG != null &&
                itemCOUNT != null
            ) {
                DetailScreen(
                    title = itemTitle,
                    desc = itemDesc,
                    price = itemPrice.toString(),
                    rating = itemRating.toString(),
                    img = itemIMG.toString(),
                    count = itemCOUNT.toString()
                )
            } else {
                Text("Item details not found")
            }
        }
    }
}