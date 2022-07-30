package com.utflnx.who.knows.backend.model.maintenance

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
data class CreateRequest(
    @field:NotBlank
    val id: String,

    @field:NotNull
    val versionCode: Int,

    @field:NotBlank
    val versionName: String,

    @field:NotNull
    val active: Boolean
)
