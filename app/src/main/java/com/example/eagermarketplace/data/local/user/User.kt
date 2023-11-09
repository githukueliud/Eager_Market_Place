package com.example.eagermarketplace.data.local.user

import androidx.room.Entity

@Entity(tableName = "users")
data class User(
    val id: Int,
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val imgUrl: String
)
