package com.sawrose.eatelicious.core.model

import com.sawrose.eatelicious.core.model.LogLevel.Debug
import com.sawrose.eatelicious.core.model.LogLevel.Error
import com.sawrose.eatelicious.core.model.LogLevel.Info
import com.sawrose.eatelicious.core.model.LogLevel.Warning
import kotlinx.datetime.Instant

/**
 * Describes an entry in a log file.
 *
 * @property level The [LogLevel] of the log entry.
 * @property timestamp The precise time at which the entry was logged.
 * @property content The log content.
 */
data class LogLine(
    val level: LogLevel?,
    val timestamp: Instant,
    val content: String,
) {
    /**
     * Returns a string representation of the log entry.
     */
    override fun toString(): String {
        return "[$timestamp] ${level?.identifier ?: 'U'}: $content"
    }
}

/**
 * Log entries (usually) come in "levels". Levels define the severity of the event that was recorded.
 * Typical log entry levels are in the following order:
 * [Debug] - An event that was logged purely for debugging.
 * [Info] - An event that was logged to communicate important information. This is the lowest
 * severity level.
 * [Warning] - An event that may be abnormal. This is the next severity level above info.
 * [Error] - A critical event, possibly fatal. This is the highest severity level.
 */
enum class LogLevel(val knownNames: Set<String>, val identifier: Char) {
    Debug(setOf("[debug]", "[Debug]", "debug:", "DEBUG", "(D)"), 'D'),
    Info(setOf("[info]", "[Info]", "info:", "INFO", "(I)", "[INF]"), 'I'),
    Warning(setOf("[warn]", "[Warn]", "[warning]", "warn:", "WARNING", "[WRN]", "(W)"), 'W'),
    Error(setOf("[error]", "[Error]", "error:", "ERROR", "[ERR]", "(E)"), 'E'),
}
