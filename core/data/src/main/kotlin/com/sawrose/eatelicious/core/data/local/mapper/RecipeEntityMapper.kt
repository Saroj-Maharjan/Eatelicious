package com.sawrose.eatelicious.core.data.local.mapper

import com.sawrose.eatelicious.commons.utils.EntityMapper
import com.sawrose.eatelicious.core.data.local.entities.RecipeEntity
import com.sawrose.eatelicious.core.model.Recipe

const val SEPERATOR = "_"

class RecipeMapper : EntityMapper<RecipeEntity, Recipe> {
    override fun mapFromEntity(entity: RecipeEntity): Recipe {
        return Recipe(
            id = entity.id,
            name = entity.name,
            image = entity.image,
            spoonacularScore = entity.spoonacularScore,
            servings = entity.servings,
            step = entity.step.split(SEPERATOR),
            ingredientOriginalString = entity.ingredientOriginalString.split(SEPERATOR),
            summary = entity.summary,
            saved = false,
        )
    }

    override fun mapToEntity(domain: Recipe): RecipeEntity {
        return RecipeEntity(
            id = domain.id,
            name = domain.name,
            image = domain.image,
            spoonacularScore = domain.spoonacularScore,
            servings = domain.servings,
            step = domain.step.joinToString(SEPERATOR),
            ingredientOriginalString = domain.ingredientOriginalString.joinToString(SEPERATOR),
            summary = domain.summary,
        )
    }
}
