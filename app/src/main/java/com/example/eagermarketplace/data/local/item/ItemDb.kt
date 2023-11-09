package com.example.eagermarketplace.data.local.item

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.eagermarketplace.data.local.item.Item
import com.example.eagermarketplace.data.local.item.ItemDao


@Database(entities = [Item::class], version = 1)
abstract class ItemDb: RoomDatabase() {
    abstract val itemDao: ItemDao
}