package com.sawrose.eatelicious.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Step(
    val number: Int,
    val step: String,
)
