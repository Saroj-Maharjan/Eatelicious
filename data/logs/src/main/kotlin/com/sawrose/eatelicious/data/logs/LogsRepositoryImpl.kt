package com.sawrose.eatelicious.data.logs

import com.sawrose.eatelicious.core.data.local.dao.FileLogDao
import com.sawrose.eatelicious.core.data.local.mapper.LogEntityMapper
import com.sawrose.eatelicious.core.domain.repository.logs.LogsRepository
import com.sawrose.eatelicious.core.model.LogLine
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LogsRepositoryImpl(
    private val logsDao: FileLogDao,
    private val mapper: LogEntityMapper,
) : LogsRepository {
    override fun getAllLogs(): Flow<List<LogLine>> =
        logsDao.getAllLogs().map {
            mapper.mapFromEntityList(it)
        }


    override suspend fun addLog(logLine: LogLine) {
        logsDao.insertLog(mapper.mapToEntity(logLine))
    }

    override suspend fun clearLogs() {
        logsDao.deleteAllLogs()
    }
}