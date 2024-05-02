package com.sawrose.eatelicious.core.data.local.mapper

import com.sawrose.eatelicious.commons.utils.EntityMapper
import com.sawrose.eatelicious.core.data.local.entities.RecipeEntity
import com.sawrose.eatelicious.core.model.Recipe

const val SEPERATOR = "_"

class RecipeMapper : EntityMapper<RecipeEntity, Recipe> {
  override fun mapFromEntity(entity: RecipeEntity): Recipe {
    return Recipe(
        id = entity.id,
        title = entity.title,
        sustainable = entity.sustainable,
        glutenFree = entity.glutenFree,
        veryPopular = entity.veryPopular,
        vegetarian = entity.vegetarian,
        dairyFree = entity.dairyFree,
        veryHealthy = entity.veryHealthy,
        vegan = entity.vegan,
        cheap = entity.cheap,
        spoonacularScore = entity.spoonacularScore,
        aggregateLikes = entity.aggregateLikes,
        sourceName = entity.sourceName,
        creditsText = entity.creditsText,
        readyInMinutes = entity.readyInMinutes,
        image = entity.image,
        percentCarbs = entity.percentCarbs,
        percentProtein = entity.percentProtein,
        percentFat = entity.percentFat,
        nutrientsAmount = entity.nutrientsAmount,
        nutrientsName = entity.nutrientsName,
        ingredientOriginalString = entity.ingredientOriginalString?.split(SEPERATOR),
        step = entity.step?.split(SEPERATOR),
    )
  }

  override fun mapToEntity(domain: Recipe): RecipeEntity {
    return RecipeEntity(
        id = domain.id,
        title = domain.title,
        sustainable = domain.sustainable,
        glutenFree = domain.glutenFree,
        veryPopular = domain.veryPopular,
        vegetarian = domain.vegetarian,
        dairyFree = domain.dairyFree,
        veryHealthy = domain.veryHealthy,
        vegan = domain.vegan,
        cheap = domain.cheap,
        spoonacularScore = domain.spoonacularScore,
        aggregateLikes = domain.aggregateLikes,
        sourceName = domain.sourceName,
        creditsText = domain.creditsText,
        readyInMinutes = domain.readyInMinutes,
        image = domain.image,
        percentCarbs = domain.percentCarbs,
        percentProtein = domain.percentProtein,
        percentFat = domain.percentFat,
        nutrientsAmount = domain.nutrientsAmount,
        nutrientsName = domain.nutrientsName,
        ingredientOriginalString = domain.ingredientOriginalString?.joinToString(SEPERATOR),
        step = domain.step?.joinToString(SEPERATOR),
    )
  }
}
