package com.sawrose.eatelicious.core.data.models

data class RecipeDto(

    val sustainable: Boolean? = null,
    val glutenFree: Boolean? = null,
    val veryPopular: Boolean? = null,
    val healthScore: Double? = null,
    val title: String? = null,
    val aggregateLikes: Int? = null,
    val creditsText: String? = null,
    val readyInMinutes: Int? = null,
    val dairyFree: Boolean? = null,
    val vegetarian: Boolean? = null,
    val id: Int,
    val image: String? = null,
    val veryHealthy: Boolean? = null,
    val vegan: Boolean? = null,
    val cheap: Boolean? = null,
    val spoonacularScore: Double? = null,
    val sourceName: String? = null,
    val nutrition: NutritionDto? = null,
    val servings: Int? = 0,
//    val analyzedInstructions: List<AnalyzedInstructionsItem>? = null,
//    val extendedIngredients: List<ExtendedIngredientsItem>? = null
)