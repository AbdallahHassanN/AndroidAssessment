package com.example.technical_assignment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.technical_assignment.models.StoreItem

@Dao
interface StoreItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertStoreItemsList(
        storeItemList: List<StoreItem>
    )

    @Query("SELECT * from StoreItem")
    suspend fun getStoreItems(): List<StoreItem>

}