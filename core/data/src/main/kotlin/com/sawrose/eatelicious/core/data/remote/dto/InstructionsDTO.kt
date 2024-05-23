package com.sawrose.eatelicious.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class InstructionsDTO(
    val name: String,
    val steps: List<Step>,
)
