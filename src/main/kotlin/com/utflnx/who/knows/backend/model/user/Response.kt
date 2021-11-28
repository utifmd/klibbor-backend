package com.utflnx.who.knows.backend.model.user

import com.utflnx.who.knows.backend.entity.Room
import java.util.*

data class Response(
    val userId: String,
    val fullName: String,
    val email: String,
    val phone: String,
    val username: String,
    val password: String,
    val createdAt: Date,
    val updatedAt: Date?,
    val room: List<Room>?
)