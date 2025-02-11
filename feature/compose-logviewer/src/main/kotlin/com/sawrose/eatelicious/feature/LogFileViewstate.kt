package com.sawrose.eatelicious.feature

import com.sawrose.eatelicious.core.model.LogLine

sealed interface LogFileViewstate {
    data object Loading : LogFileViewstate
    data class Empty(val message: String) : LogFileViewstate
    data class Success(val logs: List<LogLine>) : LogFileViewstate
}
