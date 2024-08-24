package com.sawrose.eatelicious.core.data.local

import androidx.room.TypeConverter
import kotlinx.datetime.Instant

class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Instant? {
        return if (value == null) null else Instant.fromEpochMilliseconds(value)
    }

    @TypeConverter
    fun dateToTimestamp(instant: Instant?): Long? {
        return instant?.toEpochMilliseconds()
    }

}