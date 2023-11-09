package com.example.eagermarketplace.domain.usecases.item_usecases

import com.example.eagermarketplace.data.local.Item
import com.example.eagermarketplace.data.local.ItemDao

class DeleteItem(
    private val itemDao: ItemDao
) {

    suspend operator fun invoke(item: Item) {
        itemDao.deleteItem(item)
    }

}