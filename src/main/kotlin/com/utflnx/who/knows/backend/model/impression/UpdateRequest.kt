package com.utflnx.who.knows.backend.model.impression

import javax.validation.constraints.NotNull

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
data class UpdateRequest(
    @field:NotNull
    val good: Boolean
)
