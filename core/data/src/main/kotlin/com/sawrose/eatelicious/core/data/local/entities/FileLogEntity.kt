package com.sawrose.eatelicious.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sawrose.eatelicious.core.model.LogLevel
import kotlinx.datetime.Instant

@Entity(tableName = "logs")
data class FileLogEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val level: LogLevel?,
    val timestamp: Instant,
    val content: String,
)
