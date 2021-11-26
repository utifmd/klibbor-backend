package com.utflnx.who.knows.backend.model.user

import javax.validation.constraints.NotBlank

data class UpdateRequest(
    @field:NotBlank
    val fullName: String?,

    @field:NotBlank
    val email: String?,

    @field:NotBlank //@field:NotNull @field:Min(value = 0)
    val phone: String?,

    @field:NotBlank
    val username: String?,

    @field:NotBlank
    val password: String?

)