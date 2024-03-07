package com.example.technical_assignment.network

import com.example.technical_assignment.models.StoreItem
import retrofit2.Response
import retrofit2.http.GET


interface ShopService {
    @GET("products")
    suspend fun getAllItems()
            : Response<List<StoreItem>>
}