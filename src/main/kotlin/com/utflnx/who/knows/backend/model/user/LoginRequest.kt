package com.utflnx.who.knows.backend.model.user

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class LoginRequest(
//    val username: String,
    @field:NotBlank
    val payload: String,

    @field:NotBlank
    val password: String,

    @field:NotNull
    val token: String?,
)