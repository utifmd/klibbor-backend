package com.utflnx.who.knows.backend.model.user

import javax.validation.constraints.NotBlank

data class LoginRequest(
//    val username: String,
    @field:NotBlank
    val payload: String,

    @field:NotBlank
    val password: String,

    @field:NotBlank
    val token: String,
)