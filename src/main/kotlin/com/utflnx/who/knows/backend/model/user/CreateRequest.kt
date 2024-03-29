package com.utflnx.who.knows.backend.model.user

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateRequest(
    @field:NotBlank
    val userId: String?,

    @field:NotBlank
    val email: String?,

    @field:NotNull
    val fullName: String?,

    @field:NotNull
    val profileUrl: String?,

    @field:NotNull
    //@field:Length(min = 3, max = 25)
    val phone: String?,

    @field:NotEmpty
    val tokens: List<String>?,

    @field:NotBlank //@field:NotNull @field:Min(value = 0)
    @field:Length(min = 3, max = 25)
    val username: String?,

    @field:NotBlank
    val password: String?

)