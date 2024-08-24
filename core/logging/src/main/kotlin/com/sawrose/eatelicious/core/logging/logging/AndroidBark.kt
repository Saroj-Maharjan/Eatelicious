package com.sawrose.eatelicious.core.logging.logging

import com.sawrose.eatelicious.core.domain.repository.logs.LogsRepository
import com.sawrose.eatelicious.core.logging.Extras
import com.sawrose.eatelicious.core.logging.Heartwood
import com.sawrose.eatelicious.core.model.LogLevel
import com.sawrose.eatelicious.core.model.LogLine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock

class AndroidBark(
    private val logsRepository: LogsRepository
) : Heartwood.Bark {

    override fun log(priority: LogLevel, tag: String?, extras: Extras?, message: String) {
        var msg = message
        if (extras != null) {
            msg += "\nExtras[${extras.entries.joinToString { "${it.key}:${it.value}" }}]"
        }

        val logLine = LogLine(
            level = priority,
            timestamp = Clock.System.now(),
            content = msg,
        )
        CoroutineScope(Dispatchers.IO).launch {
            logsRepository.addLog(logLine)
        }
    }
}
