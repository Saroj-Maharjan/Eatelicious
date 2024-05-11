package com.sawrose.eatelicious.core.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val CUISINE_TABLE_NAME = "cuisines"

@Entity(tableName = CUISINE_TABLE_NAME)
data class CuisineEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val videoURL: String,
    val description: String,
    val shortDescription: String,
    val thumbnailURL: String,
)