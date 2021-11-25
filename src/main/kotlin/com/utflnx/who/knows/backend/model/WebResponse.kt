package com.utflnx.who.knows.backend.model

data class WebResponse<T>(
    val code: Int,
    val status: String,
    val data: T
)