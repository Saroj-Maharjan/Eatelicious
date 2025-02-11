package com.sawrose.eatelicious.core.domain.repository.recipe

/**
 * Deine an emuration of way we can request a list of recipe in app.
 * */
sealed interface RecipeRequests {
    data class Random(
        val number: Int,
        val tags: String,
    ) : RecipeRequests

//    data class Search(
//        val query: String,
//        val cuisine: String,
//        val addIngredient: Boolean,
//        val number: Int,
//        val offset: Int,
//    ) : RecipeRequests
//
//    data class RecipeInformation(
//        val id: Int,
//        val includeNutrition: Boolean,
//    ) : RecipeRequests
}
