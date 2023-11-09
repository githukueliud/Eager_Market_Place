package com.example.eagermarketplace.data.local.user

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract val userDao: UserDao
}