package com.example.eagermarketplace.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Item::class], version = 1)
abstract class ItemDb: RoomDatabase() {
    abstract val itemDao: ItemDao
}