package com.sawrose.eatelicious.core.domain.repository.cuisine

import com.sawrose.eatelicious.core.data.RemoteDataService
import com.sawrose.eatelicious.core.model.Cuisine

interface CuisineRemoteService : RemoteDataService<CuisineRequest, List<Cuisine>> {
}