package com.sawrose.eatelicious.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sawrose.eatelicious.core.domain.repository.logs.LogsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class LogFileViewmodel(
    logRepository: LogsRepository,
) : ViewModel() {

    val viewState: StateFlow<LogFileUIState> = logRepository.getAllLogs()
        .map { logs ->
            if (logs.isEmpty()) {
                LogFileUIState.Empty("No Logs has been found")
            } else {
                LogFileUIState.Success(logs)
            }

        }
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = LogFileUIState.Loading,
        )
}