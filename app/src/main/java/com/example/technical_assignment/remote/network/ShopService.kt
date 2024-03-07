package com.example.technical_assignment.remote.network

import com.example.technical_assignment.domain.models.StoreItem
import retrofit2.Response
import retrofit2.http.GET


interface ShopService {
    @GET("products")
    suspend fun getAllItems()
            : Response<List<StoreItem>>
}