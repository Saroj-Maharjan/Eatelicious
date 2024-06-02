package com.sawrose.eatelicious.core.model

data class Recipe(
    val id: Int,
    val title: String,
    val sourceName: String,
    val image: String,
    val spoonacularScore: Double,
    val servings: Int,
    val sustainable: Boolean,
    val glutenFree: Boolean,
    val dairyFree: Boolean,
    val vegan: Boolean,
    val cheap: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean,
    val healthScore: Double,
    val aggregateLikes: Int,
    val creditsText: String,
    val readyInMinutes: Int,
    val summary: String,
    val analyzedInstructions: List<AnalyzedInstructionsItem>,
    val extendedIngredients: List<ExtendedIngredientsItem>,
    var saved: Boolean = false,
)

data class AnalyzedInstructionsItem(val steps: List<StepsItem>? = null)
data class StepsItem(val step: String? = null)

data class ExtendedIngredientsItem(val originalString: String? = null)
