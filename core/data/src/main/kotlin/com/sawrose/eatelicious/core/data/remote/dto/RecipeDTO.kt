package com.sawrose.eatelicious.core.data.remote.dto

import com.sawrose.eatelicious.core.data.local.mapper.SEPERATOR
import com.sawrose.eatelicious.core.model.Recipe
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("sourceName")
    val sourceName: String,
    @SerialName("image")
    val image: String,
    @SerialName("spoonacularScore")
    val spoonacularScore: Double,
    @SerialName("sustainable")
    val sustainable: Boolean,
    @SerialName("glutenFree")
    val glutenFree: Boolean,
    @SerialName("veryPopular")
    val veryPopular: Boolean,
    @SerialName("cheap")
    val cheap: Boolean,
    @SerialName("servings")
    val servings: Int,
    @SerialName("dairyFree")
    val dairyFree: Boolean,
    @SerialName("vegan")
    val vegan: Boolean,
    @SerialName("vegetarian")
    val vegetarian: Boolean,
    @SerialName("veryHealthy")
    val veryHealthy: Boolean,
    @SerialName("healthScore")
    val healthScore: Double,
    @SerialName("aggregateLikes")
    val aggregateLikes: Int,
    @SerialName("creditsText")
    val creditsText: String,
    @SerialName("readyInMinutes")
    val readyInMinutes: Int,
    @SerialName("summary")
    val summary: String,
    @SerialName("extendedIngredients")
    val extendedIngredients: List<IngredientsDTO>,
    @SerialName("analyzedInstructions")
    val analyzedInstructions: List<InstructionsDTO>,
)

fun RecipeDTO.toRecipe() =
    Recipe(
        id,
        title,
        sourceName,
        image,
        spoonacularScore,
        servings,
        sustainable,
        glutenFree,
        dairyFree,
        vegan,
        cheap,
        vegetarian,
        veryHealthy,
        veryPopular,
        healthScore,
        aggregateLikes,
        creditsText,
        readyInMinutes,
        summary,
        analyzedInstructions.map { it.steps.joinToString(SEPERATOR) },
        extendedIngredients.filter { it.original.isNotEmpty() }.map { it.original },
    )
