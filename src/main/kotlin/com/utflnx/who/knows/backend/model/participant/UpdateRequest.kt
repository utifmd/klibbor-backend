package com.utflnx.who.knows.backend.model.participant

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateRequest(
    @field:NotBlank
    val currentPage: String?,

    @field:NotNull
    @field:Min(value = 0)
    val timeLeft: Int?,

    @field:NotNull
    val expired: Boolean?,
)