package com.sawrose.eatelicious.commons.network

import com.sawrose.eatelicious.eatelicious.commons.BuildConfig

object SponcularEndpoints {
    val baseUrl: String
        get() = "https://api.spoonacular.com/"

    private var apiKey = BuildConfig.SPOONCULAR_API_KEY

    fun search() =
        "/recipes/complexsearch?apiKey=$apiKey"

    fun getRandomRecipes() =
        "/recipes/random?apiKey=$apiKey"

    fun getRecipe() =
        "/recipes/{id}/information?apiKey=$apiKey"

    fun getMealsPlan() =
        "mealplanner/generate?apiKey=$apiKey"

    fun getAvailableCuisines() =
        "recipes/cuisines?apiKey=$apiKey"

    fun getIngredients() =
        "food/ingredients/search?apiKey=$apiKey"
}
