package com.utflnx.who.knows.backend.model.maintenance

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
data class UpdateRequest(
    @field:NotNull
    val versionCode: Int,

    @field:NotBlank
    val versionName: String,

    @field:NotNull
    val active: Boolean
)
