package com.sawrose.eatelicious.core.model

data class Recipe(
    val id: Int,
    val name: String,
    val image: String,
    val spoonacularScore: Double,
    val servings: Int,
    val step: List<String>,
    val ingredientOriginalString: List<String>,
    val summary: String,
    var saved: Boolean = false
)
