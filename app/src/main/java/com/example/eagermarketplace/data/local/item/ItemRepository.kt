package com.example.eagermarketplace.data.local.item

import com.example.eagermarketplace.data.local.item.Item
import com.example.eagermarketplace.data.local.item.ItemDao

class ItemRepository(private val itemDao: ItemDao) {


    suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    suspend fun updateItem(item: Item) {
        itemDao.updateItem(item)
    }

    suspend fun deleteItem(item: Item) {
        itemDao.deleteItem(item)
    }
}