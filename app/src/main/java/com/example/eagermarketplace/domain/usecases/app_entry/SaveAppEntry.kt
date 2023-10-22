package com.example.eagermarketplace.domain.usecases.app_entry

import com.example.eagermarketplace.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() {
        return localUserManager.saveAppEntry()
    }

}