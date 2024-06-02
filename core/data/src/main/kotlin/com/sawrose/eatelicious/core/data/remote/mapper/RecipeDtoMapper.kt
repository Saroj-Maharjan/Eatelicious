package com.sawrose.eatelicious.core.data.remote.mapper

import com.sawrose.eatelicious.commons.utils.EntityMapper
import com.sawrose.eatelicious.core.data.remote.dto.RecipeDTO
import com.sawrose.eatelicious.core.model.Recipe

class RecipeDtoMapper : EntityMapper<RecipeDTO, Recipe> {
    override fun mapFromEntity(entity: RecipeDTO): Recipe {
        return Recipe(
            id = entity.id,
            title = entity.title,
            image = entity.image,
            spoonacularScore = entity.healthScore.toDouble(),
            servings = entity.servings,
            step = entity.analyzedInstructions.first().steps.map { it.step },
            ingredientOriginalString = entity.extendedIngredients.map { it.original },
            summary = entity.summary,
            saved = false,
        )
    }

    override fun mapToEntity(domain: Recipe): RecipeDTO {
        return RecipeDTO(
            id = domain.id,
            title = domain.name,
            image = domain.image,
            servings = domain.servings,
            aggregateLikes = 0,
            dairyFree = false,
            glutenFree = false,
            vegan = false,
            vegetarian = false,
            healthScore = domain.spoonacularScore.toInt(),
            readyInMinutes = 1,
            pricePerServing = 0.0,
            extendedIngredients = emptyList(),
            analyzedInstructions = emptyList(),
            summary = domain.summary,
            sourceName = "",
            creditsText = "",
        )
    }
}
