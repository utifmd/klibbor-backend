package com.utflnx.who.knows.backend.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class ListRequest(
    @field:NotNull
    @field:Min(value = 0)
    val page: Int,

    @field:NotNull
    @field:Min(value = 0)
    val size: Int
)