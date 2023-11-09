package com.example.eagermarketplace.domain.usecases.item_usecases

import com.example.eagermarketplace.data.local.Item
import com.example.eagermarketplace.data.local.ItemDao

class InsertItem(
    private val itemDao: ItemDao
) {

    suspend operator fun invoke(item: Item) {
        itemDao.insertItem(item)
    }
}