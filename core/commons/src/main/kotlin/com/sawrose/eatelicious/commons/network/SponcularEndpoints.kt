package com.sawrose.eatelicious.commons.network

object SponcularEndpoints {
    val baseUrl: String
        get() = "api.spoonacular.com"

    var api_key = "0c91572727934fe490aec57542fc00b8"

    fun search(apikey: String, query:String?, cuisine:String?, addRecipeInformation: Boolean?, number: Int?, offset: Int?) =
        "/recipes/complexsearch?apiKey=$apikey&query=$query&cuisine=$cuisine&addRecipeInformation=$addRecipeInformation&number=$number&offset=$offset"

    fun getRandomRecipe(apikey: String, tags: String?, number: Int?) =
        "/recipes/random?apiKey=$apikey&tags=$tags&number=$number"


}