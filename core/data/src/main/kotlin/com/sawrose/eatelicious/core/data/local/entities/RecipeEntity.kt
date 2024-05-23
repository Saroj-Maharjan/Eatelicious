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
    val name: String,
    val image: String,
    val spoonacularScore: Double,
    val servings: Int,
    val step: String,
    val ingredientOriginalString: String,
    val summary: String,
)

private const val SEPERATOR = ","
fun Recipe.mapToEntity(): RecipeEntity {
    return RecipeEntity(
        id = this.id,
        name = this.name,
        image = this.image,
        spoonacularScore = this.spoonacularScore,
        servings = this.servings,
        step = this.step.joinToString(SEPERATOR),
        ingredientOriginalString = this.ingredientOriginalString.joinToString(SEPERATOR),
        summary = this.summary,
    )
}

fun RecipeEntity.mapToRecipe(): Recipe {
    return Recipe(
        id = this.id,
        name = this.name,
        image = this.image,
        spoonacularScore = this.spoonacularScore,
        servings = this.servings,
        step = this.step.split(SEPERATOR),
        ingredientOriginalString = this.ingredientOriginalString.split(SEPERATOR),
        summary = this.summary,
    )
}
