package com.sawrose.eatelicious.core.data.di

import androidx.room.Room
import com.sawrose.eatelicious.core.data.local.AppDatabase
import com.sawrose.eatelicious.core.data.local.mapper.RecipeMapper
import com.sawrose.eatelicious.core.data.remote.BaseKtorClient
import com.sawrose.eatelicious.core.data.remote.SponcularApiClient
import com.sawrose.eatelicious.core.data.remote.mapper.RecipeDtoMapper
import com.sawrose.eatelicious.core.data.repository.RecipeRepository
import com.sawrose.eatelicious.core.data.repository.service.LocalRecipeService
import com.sawrose.eatelicious.core.data.repository.service.RemoteRecipeService
import com.sawrose.eatelicious.core.data.service.StoreRecipeService
import com.sawrose.eatelicious.core.data.service.local.RoomRecipeService
import com.sawrose.eatelicious.core.data.service.remote.SponcularRemoteService
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataKoinModule = module {
    single<BaseKtorClient> {
        SponcularApiClient
    }

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "eatelicious-db"
        )
            .build()
    }

    single { get<AppDatabase>().recipeTable }

    singleOf(::RecipeMapper)
    singleOf(::RecipeDtoMapper)

    singleOf(::SponcularRemoteService) { bind<RemoteRecipeService>() }
    singleOf(::RoomRecipeService) { bind<LocalRecipeService>() }
    singleOf(::StoreRecipeService) { bind<RecipeRepository>() }

}