package com.sawrose.eatelicious.core.domain.repository.cuisine

import com.sawrose.eatelicious.core.data.LocalDataService
import com.sawrose.eatelicious.core.model.Cuisine

interface LocalCuisineService: LocalDataService<CuisineRequest, List<Cuisine>> {
}