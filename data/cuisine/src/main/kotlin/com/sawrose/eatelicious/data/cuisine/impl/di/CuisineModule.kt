package com.sawrose.eatelicious.data.cuisine.impl.di

import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRemoteService
import com.sawrose.eatelicious.core.domain.repository.cuisine.CuisineRepository
import com.sawrose.eatelicious.core.domain.repository.cuisine.LocalCuisineService
import com.sawrose.eatelicious.data.cuisine.impl.CuisineRemoteSevice
import com.sawrose.eatelicious.data.cuisine.impl.CuisineRoomService
import com.sawrose.eatelicious.data.cuisine.impl.CuisineStoreService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val cuisineModule = module {
    singleOf(::CuisineRemoteSevice) bind CuisineRemoteService::class
    singleOf(::CuisineRoomService) bind LocalCuisineService::class
    singleOf(::CuisineStoreService) bind CuisineRepository::class
}
