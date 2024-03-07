package com.example.technical_assignment.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.technical_assignment.db.StoreItemDao
import com.example.technical_assignment.models.StoreItem


@Database(
    entities = [StoreItem::class],
    version = 1,
    exportSchema = false
)
abstract class StoreItemDatabase : RoomDatabase() {

    abstract val storeItemDao: StoreItemDao
}