package com.utflnx.who.knows.backend.model.file

import javax.validation.constraints.NotEmpty

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
data class ListRequest(
    @field:NotEmpty
    val ids: List<String>
)
