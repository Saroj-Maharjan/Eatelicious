package com.sawrose.eatelicious.core.domain.repository.cuisine

sealed interface CuisineRequest {
    data object Search : CuisineRequest
}
