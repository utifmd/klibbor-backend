package com.utflnx.who.knows.backend.model.result

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateRequest(

    @field:NotBlank
    val resultId: String?,

    @field:NotBlank
    val roomId: String?,

    @field:NotBlank
    val userId: String?,

    @field:NotNull
    val correctQuiz: List<String>?,

    @field:NotNull
    val wrongQuiz: List<String>?,

    @field:NotNull
    val score: Int?
)