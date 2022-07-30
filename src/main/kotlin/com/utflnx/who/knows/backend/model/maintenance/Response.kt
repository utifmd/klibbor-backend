package com.utflnx.who.knows.backend.model.maintenance

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
data class Response(
    val id: String,
    val versionCode: Int,
    val versionName: String,
    val active: Boolean
)
