package com.sawrose.eatelicious.core.domain.repository.cuisine

import com.sawrose.eatelicious.core.data.Repository
import com.sawrose.eatelicious.core.model.Cuisine

interface CuisineRepository : Repository<CuisineRequest, List<Cuisine>>
