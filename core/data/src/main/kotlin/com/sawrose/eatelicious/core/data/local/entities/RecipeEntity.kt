package com.sawrose.eatelicious.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sawrose.eatelicious.core.model.Recipe

@Entity(
    tableName = "Recipes",
)
data class RecipeEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val sourceName: String,
    val image: String,
    val aggregateLikes: Int,
    val spoonacularScore: Double,
    val servings: Int,
    val readyInMinutes: Int,
    val healthScore: Double,
    val sustainable: Boolean,
    val glutenFree: Boolean,
    val veryPopular: Boolean,
    val dairyFree: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val vegan: Boolean,
    val cheap: Boolean,
    val step: String,
    val ingredientOriginalString: String,
    val creditsText: String,
    val summary: String,
)