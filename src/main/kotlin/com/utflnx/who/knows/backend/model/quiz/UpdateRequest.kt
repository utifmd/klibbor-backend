package com.utflnx.who.knows.backend.model.quiz

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateRequest(

    @field:NotNull
    val images: List<String>,

    @field:NotBlank
    val question: String,

    @field:NotNull
    val options: List<String>,

    @field:NotBlank
    val answer: String,

    @field:NotBlank
    val createdBy: String
)