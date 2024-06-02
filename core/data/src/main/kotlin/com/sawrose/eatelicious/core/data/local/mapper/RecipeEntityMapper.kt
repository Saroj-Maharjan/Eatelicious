package com.sawrose.eatelicious.core.data.local.mapper

import com.sawrose.eatelicious.commons.utils.EntityMapper
import com.sawrose.eatelicious.core.data.local.entities.RecipeEntity
import com.sawrose.eatelicious.core.model.AnalyzedInstructionsItem
import com.sawrose.eatelicious.core.model.ExtendedIngredientsItem
import com.sawrose.eatelicious.core.model.Recipe
import com.sawrose.eatelicious.core.model.StepsItem

const val SEPERATOR = "_"

class RecipeMapper : EntityMapper<RecipeEntity, Recipe> {
    override fun mapFromEntity(entity: RecipeEntity): Recipe {
        return Recipe(
            id = entity.id,
            title = entity.title,
            sourceName = entity.sourceName,
            image = entity.image,
            spoonacularScore = entity.spoonacularScore,
            servings = entity.servings,
            sustainable = entity.sustainable,
            glutenFree = entity.glutenFree,
            dairyFree = entity.dairyFree,
            vegan = entity.vegan,
            cheap = entity.cheap,
            vegetarian = entity.vegetarian,
            veryHealthy = entity.veryHealthy,
            veryPopular = entity.veryPopular,
            healthScore = entity.healthScore,
            aggregateLikes = entity.aggregateLikes,
            creditsText = entity.creditsText,
            readyInMinutes = entity.readyInMinutes,
            summary = entity.summary,
            analyzedInstructions = entity.step.split(SEPERATOR).map { step ->
                AnalyzedInstructionsItem(
                    steps = listOf(
                        StepsItem(
                            step = step,
                        ),
                    ),
                )
            },
            extendedIngredients = entity.ingredientOriginalString.split(SEPERATOR)
                .map { ingredient ->
                    ExtendedIngredientsItem(
                        originalString = ingredient,
                    )
                },
            saved = false,
        )
    }

    override fun mapToEntity(domain: Recipe): RecipeEntity {
        return RecipeEntity(
            id = domain.id,
            title = domain.title,
            sourceName = domain.sourceName,
            image = domain.image,
            spoonacularScore = domain.spoonacularScore,
            servings = domain.servings,
            sustainable = domain.sustainable,
            glutenFree = domain.glutenFree,
            dairyFree = domain.dairyFree,
            vegan = domain.vegan,
            cheap = domain.cheap,
            vegetarian = domain.vegetarian,
            veryHealthy = domain.veryHealthy,
            veryPopular = domain.veryPopular,
            healthScore = domain.healthScore,
            aggregateLikes = domain.aggregateLikes,
            creditsText = domain.creditsText,
            readyInMinutes = domain.readyInMinutes,
            summary = domain.summary,
            step = domain.analyzedInstructions.joinToString(separator = SEPERATOR),
            ingredientOriginalString = domain.extendedIngredients.joinToString(SEPERATOR),
        )
    }
}
