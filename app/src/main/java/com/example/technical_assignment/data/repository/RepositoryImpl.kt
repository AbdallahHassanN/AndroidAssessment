package com.example.technical_assignment.data.repository

import android.content.Context
import android.util.Log
import com.example.technical_assignment.presentation.common.Constants
import com.example.technical_assignment.presentation.common.handleResponse
import com.example.technical_assignment.local.db.StoreItemDao
import com.example.technical_assignment.domain.models.StoreItem
import com.example.technical_assignment.domain.repository.Repository
import com.example.technical_assignment.remote.network.ShopService
import com.example.technical_assignment.remote.network.response.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.UnknownHostException


class RepositoryImpl(
    private val shopService: ShopService,
    private val appContext: Context,
    private val dao: StoreItemDao
) : Repository {
    override suspend fun getAllItems()
            : Flow<Resource<List<StoreItem>>> {
        return try {
            val response = shopService.getAllItems()
            if (response.isSuccessful) {
                dao.upsertStoreItemsList(response.body()!!)
            }
            handleResponse(response, appContext)
        } catch (e: UnknownHostException) {
            flow {
                val itemsLocal = dao.getStoreItems()
                if (itemsLocal.isNotEmpty()) {
                    emit(Resource.Success(itemsLocal))
                } else {
                    emit(Resource.Error("No internet connection and no data in RoomDB"))
                }
            }
        } catch (e: Exception) {
            flow {
                emit(Resource.Error("An unexpected error occurred"))
                Log.d(Constants.TAG, e.message.toString())
            }
        }
    }
}