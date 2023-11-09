package com.example.eagermarketplace.domain.usecases.user_usecases

import com.example.eagermarketplace.data.local.user.User
import com.example.eagermarketplace.data.local.user.UserDao

class DeleteUser(
    private val userDao: UserDao
) {
    suspend operator fun invoke(user: User) {
        userDao.deleteUSer(user)
    }
}