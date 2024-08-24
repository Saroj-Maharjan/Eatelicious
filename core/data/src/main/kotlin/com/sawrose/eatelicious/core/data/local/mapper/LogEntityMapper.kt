package com.sawrose.eatelicious.core.data.local.mapper

import com.sawrose.eatelicious.commons.utils.EntityMapper
import com.sawrose.eatelicious.core.data.local.entities.FileLogEntity
import com.sawrose.eatelicious.core.model.LogLine

class LogEntityMapper: EntityMapper<FileLogEntity, LogLine> {
    override fun mapFromEntity(entity: FileLogEntity): LogLine {
        return LogLine(
            level = entity.level,
            timestamp = entity.timestamp,
            content = entity.content
        )
    }

    override fun mapToEntity(domain: LogLine): FileLogEntity {
        return FileLogEntity(
            level = domain.level,
            timestamp = domain.timestamp,
            content = domain.content
        )
    }
}