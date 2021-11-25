package com.utflnx.who.knows.backend.model.user

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateRequest(
    @field:NotBlank
    val userId: String?,

    @field:NotBlank
    val fullName: String?,

    @field:NotBlank
    val email: String?,

    @field:NotNull
    @field:Min(value = 0)
    val phone: Int?,

    @field:NotBlank
    val username: String?,

    @field:NotBlank
    val password: String?

)