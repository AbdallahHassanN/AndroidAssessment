package com.example.technical_assignment.repository

import com.example.technical_assignment.models.StoreItem
import com.example.technical_assignment.network.response.Resource
import kotlinx.coroutines.flow.Flow


interface Repository {

    suspend fun getAllItems()
            : Flow<Resource<List<StoreItem>>>
}