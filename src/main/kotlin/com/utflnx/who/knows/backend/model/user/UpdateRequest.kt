package com.utflnx.who.knows.backend.model.user

import javax.validation.constraints.NotNull

data class UpdateRequest(
    @field:NotNull
    val fullName: String?,

    @field:NotNull
    val email: String?,

    @field:NotNull //@field:NotNull @field:Min(value = 0)
    val phone: String?,

    @field:NotNull
    val username: String?,

    //@field:NotEmpty
    @field:NotNull
    val tokens: List<String>?,

    @field:NotNull
    val password: String?,

    @field:NotNull
    val profileUrl: String?
)