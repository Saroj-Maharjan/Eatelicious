package com.sawrose.eatelicious.core.data.di

import com.sawrose.eatelicious.core.data.remote.BaseKtorClient
import com.sawrose.eatelicious.core.data.remote.SponcularApiClient
import com.sawrose.eatelicious.core.data.service.StoreRecipeService
import com.sawrose.eatelicious.core.data.service.local.RoomRecipeService
import com.sawrose.eatelicious.core.data.service.remote.SponcularRemoteService
import com.sawrose.eatelicious.core.domain.repository.RecipeRepository
import com.sawrose.eatelicious.core.domain.service.RemoteRecipeService
import org.koin.dsl.module

val DataModule = module {
    single<BaseKtorClient> {
        SponcularApiClient
    }

    single<RemoteRecipeService> {
        SponcularRemoteService(
            apiClient = get()
        )
    }

    single {
        RoomRecipeService(
            database = get(),
            mapper = get()
        )
    }

    single<RecipeRepository> {
        StoreRecipeService(
            remoteRecipeService = get(),
            localRecipeService = get(),
        )
    }
}