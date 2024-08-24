package com.sawrose.eatelicious.core.domain.repository.logs

import com.sawrose.eatelicious.core.model.LogLine
import kotlinx.coroutines.flow.Flow

interface LogsRepository {
    fun getAllLogs(): Flow<List<LogLine>>

    suspend fun addLog(logLine: LogLine)

    suspend fun clearLogs()

}