package com.utflnx.who.knows.backend.model.impression

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
data class CreateRequest(

    @field:NotBlank
    val impressionId: String,

    @field:NotBlank
    val postId: String,

    @field:NotBlank
    val userId: String,

    @field:NotNull
    val good: Boolean
)
