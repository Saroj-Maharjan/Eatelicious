package com.sawrose.eatelicious.commons.network

import com.sawrose.eatelicious.eatelicious.commons.BuildConfig

object SponcularEndpoints {
    val baseUrl: String
        get() = "https://api.spoonacular.com/"

    private var apiKey = BuildConfig.SPOONCULAR_API_KEY

    fun search() =
        "/recipes/complexsearch?apiKey=$apiKey"

    fun getRandomRecipe() =
        "/recipes/random?apiKey=$apiKey"
}
