package com.utflnx.who.knows.backend.model.participant

import java.util.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateRequest(
    @field:NotBlank
    val participantId: String?,

    @field:NotBlank
    val roomId: String?,

    @field:NotBlank
    val userId: String?,

    @field:NotBlank
    val currentPage: String?,

    @field:NotNull
    @field:Min(value = 0)
    val timeLeft: Int?,

    @field:NotNull
    val expired: Boolean?
)