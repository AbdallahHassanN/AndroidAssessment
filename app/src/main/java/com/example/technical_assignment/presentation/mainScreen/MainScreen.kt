package com.example.technical_assignment.presentation.mainScreen


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.technical_assignment.common.Constants.TAG
import com.example.technical_assignment.common.components.StoreItemList

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val itemsList = viewModel.itemsList.value
    val loading = viewModel.loading.value


    Log.d(TAG,"items: $itemsList")
    Scaffold(
    ) { padding ->
        StoreItemList(loading = loading, storeItems = itemsList,
            it = padding, navController = navController)
    }
}