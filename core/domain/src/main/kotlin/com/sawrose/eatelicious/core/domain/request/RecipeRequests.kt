package com.sawrose.eatelicious.core.domain.request

/**
 * Deine an emuration of way we can request a list of recipe in app.
 * */
sealed interface RecipeRequests {
    data class random(
        val number: Int,
        val tags: String,
    ): RecipeRequests


    data class search(
        val query: String,
        val cuisine: String,
        val addIngredient: Boolean,
        val number: Int,
        val offset: Int,
    ): RecipeRequests
}