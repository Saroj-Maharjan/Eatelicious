package com.sawrose.eatelicious.core.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientsDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("aisle")
    val aisle: String,
    @SerialName("consistency")
    val consistency: String,
    @SerialName("amount")
    val amount: Double,
    @SerialName("original")
    val original: String,
)