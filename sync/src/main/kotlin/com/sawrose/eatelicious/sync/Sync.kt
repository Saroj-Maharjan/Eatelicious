package com.sawrose.eatelicious.sync

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.sawrose.eatelicious.sync.workers.SyncWorker

object Sync {
    // This method is initializes sync, the process keeps the app's data current

    fun initialize(context: Context) {
        WorkManager.getInstance(context).apply {
            enqueueUniqueWork(
                SyncWorkName,
                ExistingWorkPolicy.KEEP,
                SyncWorker.startUpSyncWork(),
            )
        }
    }
}

// This name should not be changed otherwise the app may have concurrent sync requests running
internal const val SyncWorkName = "EateliciousSyncWorkName"