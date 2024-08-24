package com.sawrose.eatelicious.feature

import com.sawrose.eatelicious.core.model.LogLine

sealed interface LogFileUIState {
    data object Loading : LogFileUIState
    data class Empty(val message: String) : LogFileUIState
    data class Success(val logs: List<LogLine>) : LogFileUIState
}