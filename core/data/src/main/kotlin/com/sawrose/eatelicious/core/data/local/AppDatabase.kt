package com.sawrose.eatelicious.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sawrose.eatelicious.core.data.local.dao.RecipeDao
import com.sawrose.eatelicious.core.data.local.entities.CuisineEntity
import com.sawrose.eatelicious.core.data.local.entities.IngredientEntity
import com.sawrose.eatelicious.core.data.local.entities.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class,
        CuisineEntity::class,
        IngredientEntity::class,
    ],
    exportSchema = false,
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract val recipeTable: RecipeDao
}
