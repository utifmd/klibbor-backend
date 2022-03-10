package com.utflnx.who.knows.backend.model.notification

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
data class UpdateRequest(
    @field:NotBlank
    val event: String,

    @field:NotNull
    val seen: Boolean
)
