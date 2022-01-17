package com.utflnx.who.knows.backend.model.room

import com.utflnx.who.knows.backend.entity.Participant
import com.utflnx.who.knows.backend.entity.Quiz
import java.util.*

data class Response(
    val roomId: String,
    val userId: String,
    val minute: Int,
    val title: String,
    val description: String,
    val expired: Boolean,
    val createdAt: Date,
    val updatedAt: Date?, // val user: User?
    val questions: List<Quiz>,
    val participants: List<Participant>
)