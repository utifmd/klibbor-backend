package com.utflnx.who.knows.backend.model.room

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateRequest(
    @field:NotBlank
    val roomId: String?,

    @field:NotBlank
    val userId: String?,

    @field:NotNull
    @field:Min(value = 0)
    val minute: Int?,

    @field:NotBlank
    val title: String?,

    @field:NotBlank
    val description: String?,

    @field:NotBlank
    val token: String?,

    @field:NotNull
    val expired: Boolean?,

    @field:NotNull
    val private: Boolean?,
)