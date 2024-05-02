package com.sawrose.eatelicious.sync.util

import android.util.Log
import kotlin.coroutines.cancellation.CancellationException

interface Synchronizer {

    suspend fun Syncable.sync() = this@Synchronizer.syncWith(this@Synchronizer)
}

interface Syncable {
    /**
     * Synchronize the local database backing the repository with Network
     * */
    suspend fun syncWith(synchronizer: Synchronizer): Boolean
}

/**
 * Attempts [block], returning a successful [Result] if it succeeds, otherwise a [Result.Failure]
 * taking care not to break structured concurrency
 */
private suspend fun <T> suspendRunCatching(block: suspend () -> T): Result<T> = try {
    Result.success(block())
} catch (cancellationException: CancellationException) {
    throw cancellationException
} catch (exception: Exception) {
    Log.i(
        "suspendRunCatching",
        "Failed to evaluate a suspendRunCatchingBlock. Returning failure Result",
        exception,
    )
    Result.failure(exception)
}