package com.utflnx.who.knows.backend.model.user

import com.utflnx.who.knows.backend.entity.Participant
import com.utflnx.who.knows.backend.entity.Room
import java.util.*

data class Response(
    val userId: String,
    val fullName: String,
    val email: String,
    val phone: String,
    val username: String,
    val password: String,
    val profileUrl: String,
    val createdAt: Date,
    val updatedAt: Date?,
    val participants: List<Participant>,
    val rooms: List<Room>
)