package com.example.eagermarketplace.data.local.user

class UserRepository(
    private val userDao: UserDao
) {

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUSer(user)
    }

}