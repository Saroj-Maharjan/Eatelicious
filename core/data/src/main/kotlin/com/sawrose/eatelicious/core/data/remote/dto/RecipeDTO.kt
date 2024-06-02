package com.sawrose.eatelicious.core.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("image")
    val image: String,
    @SerialName("servings")
    val servings: Int,
    @SerialName("aggregateLikes")
    val aggregateLikes: Int,
    @SerialName("dairyFree")
    val dairyFree: Boolean,
    @SerialName("glutenFree")
    val glutenFree: Boolean,
    @SerialName("vegan")
    val vegan: Boolean,
    @SerialName("vegetarian")
    val vegetarian: Boolean,
    @SerialName("healthScore")
    val healthScore: Int,
    @SerialName("readyInMinutes")
    val readyInMinutes: Int,
    @SerialName("pricePerServing")
    val pricePerServing: Double,
    @SerialName("extendedIngredients")
    val extendedIngredients: List<IngredientsDTO>,
    @SerialName("analyzedInstructions")
    val analyzedInstructions: List<InstructionsDTO>,
    @SerialName("summary")
    val summary: String,
    @SerialName("sourceName")
    val sourceName: String,
    @SerialName("creditsText")
    val creditsText: String,
)
