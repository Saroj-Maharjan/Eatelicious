package com.sawrose.eatelicious.data.cuisine.impl

import com.sawrose.eatelicious.core.data.local.dao.CuisineDao
import com.sawrose.eatelicious.core.data.local.mapper.CuisineEntityMapper
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRequest
import com.sawrose.eatelicious.core.domain.repository.cuisine.LocalCuisineService
import com.sawrose.eatelicious.core.model.Cuisine
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CuisineRoomService(
    private val cuisineDao: CuisineDao,
    private val mapper: CuisineEntityMapper,
) : LocalCuisineService {
    override fun stream(request: CuisineRequest): Flow<List<Cuisine>> {
        return when (request) {
            is CuisineRequest.Search -> {
                cuisineDao
                    .getCuisines()
                    .map {
                        mapper.mapFromEntityList(it)
                    }
            }
        }
    }

    override suspend fun insert(data: List<Cuisine>) {
        val cuisines = mapper.mapFromDomainList(data)
        cuisineDao.insertAll(cuisines)
    }
}