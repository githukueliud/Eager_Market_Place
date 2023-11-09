package com.example.eagermarketplace.domain.usecases.item_usecases

import com.example.eagermarketplace.data.local.item.Item
import com.example.eagermarketplace.data.local.item.ItemDao

class InsertItem(
    private val itemDao: ItemDao
) {

    suspend operator fun invoke(item: Item) {
        itemDao.insertItem(item)
    }
}