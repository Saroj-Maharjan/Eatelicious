package com.sawrose.eatelicious.core.data.local.mapper

import com.sawrose.eatelicious.commons.utils.EntityMapper
import com.sawrose.eatelicious.core.data.local.entities.CuisineEntity
import com.sawrose.eatelicious.core.model.Cuisine

class CuisineEntityMapper : EntityMapper<CuisineEntity, Cuisine> {
    override fun mapFromEntity(entity: CuisineEntity): Cuisine {
        return Cuisine(
            image = entity.image,
            title = entity.title,
            color = entity.color,
        )
    }

    override fun mapToEntity(domain: Cuisine): CuisineEntity {
        return CuisineEntity(
            image = domain.image,
            title = domain.title,
            color = domain.color,
        )
    }
}
