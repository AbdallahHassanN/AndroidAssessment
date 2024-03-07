package com.example.technical_assignment.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.technical_assignment.domain.models.StoreItem


@Database(
    entities = [StoreItem::class],
    version = 1,
    exportSchema = false
)
abstract class StoreItemDatabase : RoomDatabase() {

    abstract val storeItemDao: StoreItemDao
}