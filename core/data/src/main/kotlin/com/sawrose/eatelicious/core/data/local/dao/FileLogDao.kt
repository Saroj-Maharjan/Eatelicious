package com.sawrose.eatelicious.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sawrose.eatelicious.core.data.local.entities.FileLogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FileLogDao {

    @Insert
    suspend fun insertLog(log: FileLogEntity)

    @Query("SELECT * FROM logs")
    fun getAllLogs(): Flow<List<FileLogEntity>>

    @Query("DELETE FROM logs")
    suspend fun deleteAllLogs()

    @Query("SELECT * FROM logs WHERE id = :id")
    suspend fun getLogById(id: Int): FileLogEntity?
}