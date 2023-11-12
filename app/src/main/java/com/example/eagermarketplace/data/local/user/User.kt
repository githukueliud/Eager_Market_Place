package com.example.eagermarketplace.data.local.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val imgUrl: String
)



