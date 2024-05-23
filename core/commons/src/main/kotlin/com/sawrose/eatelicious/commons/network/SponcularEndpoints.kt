package com.sawrose.eatelicious.commons.network

object SponcularEndpoints {
    val baseUrl: String
        get() = "api.spoonacular.com"

    private var apiKey = "0c91572727934fe490aec57542fc00b8"

    fun search() =
        "/recipes/complexsearch?apiKey=$apiKey"

    fun getRandomRecipe() =
        "/recipes/random?apiKey=$apiKey"
}
