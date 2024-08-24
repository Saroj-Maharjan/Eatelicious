package com.sawrose.eatelicious.core.data.di

import androidx.room.Room
import com.sawrose.eatelicious.core.data.local.AppDatabase
import com.sawrose.eatelicious.core.data.local.dao.CuisineDao
import com.sawrose.eatelicious.core.data.local.dao.FileLogDao
import com.sawrose.eatelicious.core.data.local.dao.RecipeDao
import com.sawrose.eatelicious.core.data.local.mapper.CuisineEntityMapper
import com.sawrose.eatelicious.core.data.local.mapper.LogEntityMapper
import com.sawrose.eatelicious.core.data.local.mapper.RecipeEntityMapper
import com.sawrose.eatelicious.core.data.remote.ApiStateProvider
import com.sawrose.eatelicious.core.data.remote.SpooncularApiStateProvider
import com.sawrose.eatelicious.core.data.remote.getHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataKoinModule = module {
    // API state
    singleOf(::SpooncularApiStateProvider) bind ApiStateProvider::class

    //Ktor Client
    singleOf(::getHttpClient)


    single<AppDatabase> {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "eatelicious.db",
        )
            .build()
    }

    single<RecipeDao> { get<AppDatabase>().recipeTable }
    single<CuisineDao> { get<AppDatabase>().cuisineTable }
    single<FileLogDao> { get<AppDatabase>().logTable }

    factoryOf(::CuisineEntityMapper)
    factoryOf(::RecipeEntityMapper)
    factoryOf(::LogEntityMapper)
}
