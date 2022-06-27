package com.utflnx.who.knows.backend.model.room

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateRequest(

    @field:NotNull
    @field:Min(value = 0)
    val minute: Int?,

    @field:NotNull
    @field:NotBlank
    val title: String?,

    @field:NotNull
    @field:NotBlank
    val description: String?,

    @field:NotNull
    @field:NotBlank
    val token: String?,

    @field:NotNull
    val expired: Boolean?,

    @field:NotNull
    val private: Boolean?
)