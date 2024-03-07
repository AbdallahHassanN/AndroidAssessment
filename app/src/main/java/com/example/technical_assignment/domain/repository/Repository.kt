package com.example.technical_assignment.domain.repository

import com.example.technical_assignment.domain.models.StoreItem
import com.example.technical_assignment.remote.network.response.Resource
import kotlinx.coroutines.flow.Flow


interface Repository {

    suspend fun getAllItems()
            : Flow<Resource<List<StoreItem>>>
}