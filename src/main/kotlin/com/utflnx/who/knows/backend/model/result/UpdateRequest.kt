package com.utflnx.who.knows.backend.model.result

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateRequest(

    @field:NotNull
    val correctQuiz: List<String>?,

    @field:NotNull
    val wrongQuiz: List<String>?,

    @field:NotNull
    @field:Min(value = 0)
    val score: Int?
)