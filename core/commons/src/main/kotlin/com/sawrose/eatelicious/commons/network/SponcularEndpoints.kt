package com.sawrose.eatelicious.commons.network

object SponcularEndpoints {
    val baseUrl: String
        get() = "api.spoonacular.com"

    var api_key = "0c91572727934fe490aec57542fc00b8"

    fun search() =
        "/recipes/complexsearch?apiKey=$api_key"

    fun getRandomRecipe() =
        "/recipes/random?apiKey=$api_key"


}