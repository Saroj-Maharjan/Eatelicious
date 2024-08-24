package com.sawrose.eatelicious.core.domain.usecase

import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRepository
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRequest

class GetCuisineUsecase(
    private val repository: CuisineRepository,
) {

    operator fun invoke(request: CuisineRequest) =
        repository.stream(request)
}
