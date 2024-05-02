package com.sawrose.eatelicious.sync.util

import kotlinx.coroutines.flow.Flow

// Report on if the Sync is in progress
interface SyncManager {
    val isSyncing: Flow<Boolean>
    fun requestSync()
}