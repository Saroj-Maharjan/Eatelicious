package com.sawrose.eatelicious.data.recipe.impl.di

import com.sawrose.eatelicious.core.domain.repository.recipe.LocalRecipeService
import com.sawrose.eatelicious.core.domain.repository.recipe.RecipeRepository
import com.sawrose.eatelicious.core.domain.repository.recipe.RemoteRecipeService
import com.sawrose.eatelicious.data.recipe.impl.RecipeRemoteService
import com.sawrose.eatelicious.data.recipe.impl.RecipeRoomService
import com.sawrose.eatelicious.data.recipe.impl.RecipeStoreService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val recipeModule = module {
    singleOf(::RecipeRemoteService) bind RemoteRecipeService::class
    singleOf(::RecipeRoomService) bind LocalRecipeService::class
    singleOf(::RecipeStoreService) bind RecipeRepository::class
}
