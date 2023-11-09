package com.example.eagermarketplace.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val price: Int,
    val quantity: Int,
    val description: String,
    val imgUrl: String
)
