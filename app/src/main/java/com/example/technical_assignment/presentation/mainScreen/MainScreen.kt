package com.example.technical_assignment.presentation.mainScreen


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.technical_assignment.presentation.common.Constants.TAG
import com.example.technical_assignment.presentation.common.components.StoreItemList
import com.example.technical_assignment.presentation.viewmodels.MainScreenViewModel
import com.example.technical_assignment.remote.network.response.Resource

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val itemsList = viewModel.itemsList.value
    val loading = viewModel.loading.value
    val dataState = viewModel.dataState.value
    val snackBarHostState = remember { SnackbarHostState() }

    suspend fun showSnackBar(message: String) {
        snackBarHostState.showSnackbar(message)
    }

    dataState.let {
        when (it) {
            is Resource.Error -> {
                LaunchedEffect(Unit) {
                    val error = it.message
                    showSnackBar(error.toString())
                    Log.d(TAG, error.toString())
                }
            }
            else -> {
                Log.d(TAG, "Unexpected Error1")
            }
        }
    }

    Log.d(TAG, "items: $itemsList")
    Scaffold { padding ->
        StoreItemList(
            loading = loading, storeItems = itemsList,
            it = padding, navController = navController
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp), // Adjust padding as needed
            contentAlignment = Alignment.BottomCenter
        ) {
            SnackbarHost(
                hostState = snackBarHostState,
            ) { snackBar ->
                Snackbar(
                    snackbarData = snackBar,
                    containerColor = Color.Red
                )
            }
        }
    }
}