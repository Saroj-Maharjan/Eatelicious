package com.sawrose.eatelicious.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sawrose.eatelicious.core.data.local.entities.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecipe(recipe: RecipeEntity)

    @Query("SELECT * FROM Recipes")
    fun getRecipes(): Flow<List<RecipeEntity>>

//    @Transaction
//    @Query("SELECT * FROM Recipes")
//    fun getPagedRecipes(): PagingSource<Int, RecipeEntity>

    @Query("SELECT * FROM Recipes WHERE id=:recipeId")
    suspend fun getRecipe(recipeId: Int?): RecipeEntity?

    @Query("DELETE FROM Recipes WHERE id=:recipeId")
    suspend fun deleteRecipe(recipeId: Int?)

    @Query("SELECT COUNT(*) FROM Recipes WHERE id=:recipeId")
    suspend fun isRecipeSaved(recipeId: Int?): Boolean
}
