package com.utflnx.who.knows.backend.model.impression

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
data class Response(
    val impressionId: String,
    val postId: String,
    val userId: String,
    val good: Boolean
)
