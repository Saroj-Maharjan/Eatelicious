package com.sawrose.eatelicious.logging

import android.util.Log
import com.sawrose.eatelicious.core.logging.Extras
import com.sawrose.eatelicious.core.logging.Heartwood
import com.sawrose.eatelicious.core.logging.LogPriority

class AndroidBark : Heartwood.Bark {

    override fun log(priority: LogPriority, tag: String?, extras: Extras?, message: String) {
        var msg = message
        if (extras != null) {
            msg += "\nExtras[${extras.entries.joinToString { "${it.key}:${it.value}" }}]"
        }

        Log.println(priority.priority, tag, msg)
    }
}
