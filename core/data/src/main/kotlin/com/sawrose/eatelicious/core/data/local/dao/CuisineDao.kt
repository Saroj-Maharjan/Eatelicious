package com.sawrose.eatelicious.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sawrose.eatelicious.core.data.local.entities.CuisineEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CuisineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<CuisineEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cuisine: CuisineEntity)

    @Query("SELECT * FROM cuisines")
    fun getCuisines(): Flow<List<CuisineEntity>>

    @Query("SELECT * FROM cuisines WHERE id=:cuisineId")
    suspend fun getCuisine(cuisineId: Int): CuisineEntity?
}
