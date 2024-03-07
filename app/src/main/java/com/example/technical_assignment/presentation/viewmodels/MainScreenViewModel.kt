package com.example.technical_assignment.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technical_assignment.presentation.common.Constants.TAG
import com.example.technical_assignment.domain.models.StoreItem
import com.example.technical_assignment.remote.network.response.Resource
import com.example.technical_assignment.domain.useCases.GetAllItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel
@Inject constructor(
    private val getAllItemsUseCase: GetAllItemsUseCase
) : ViewModel() {
    private val _itemsList = MutableStateFlow<List<StoreItem>>(listOf())
    val itemsList = _itemsList.asStateFlow()
    val loading = mutableStateOf(false)

    init {
        getAllItems()
    }

    private fun getAllItems() = viewModelScope.launch {
        loading.value = true
        getAllItemsUseCase.execute(
        ).catch {
            Log.d(TAG, "Error ${it.message}")
        }.collect { response ->
            when (response) {
                is Resource.Error -> {
                    Log.d(TAG, "Error response")
                    loading.value = false
                }

                is Resource.Loading -> {
                    loading.value = true
                    Log.d(TAG, "Loading")
                }

                is Resource.Success -> {
                    _itemsList.value = response.data!!
                    Log.d(TAG, "dataView ${_itemsList.value}")
                    loading.value = false
                }
            }
        }
    }
}

