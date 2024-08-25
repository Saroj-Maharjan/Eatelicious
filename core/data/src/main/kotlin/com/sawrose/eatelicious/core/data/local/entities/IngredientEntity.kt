package com.sawrose.eatelicious.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val INGREDIENTS_TABLE_NAME = "ingredients"

@Entity(tableName = INGREDIENTS_TABLE_NAME)
class IngredientEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val image: String,
    val background: String,
)
