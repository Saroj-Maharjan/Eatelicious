package com.sawrose.eatelicious.core.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    @SerialName("recipes")
    val recipes: List<RecipeDTO>,
)