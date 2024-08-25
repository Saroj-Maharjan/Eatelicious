package com.sawrose.eatelicious.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sawrose.eatelicious.core.data.local.dao.CuisineDao
import com.sawrose.eatelicious.core.data.local.dao.FileLogDao
import com.sawrose.eatelicious.core.data.local.dao.RecipeDao
import com.sawrose.eatelicious.core.data.local.entities.CuisineEntity
import com.sawrose.eatelicious.core.data.local.entities.FileLogEntity
import com.sawrose.eatelicious.core.data.local.entities.IngredientEntity
import com.sawrose.eatelicious.core.data.local.entities.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class,
        CuisineEntity::class,
        IngredientEntity::class,
        FileLogEntity::class,
    ],
    exportSchema = false,
    version = 1,
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val recipeTable: RecipeDao
    abstract val cuisineTable: CuisineDao
    abstract val logTable: FileLogDao
}
