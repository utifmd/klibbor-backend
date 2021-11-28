package com.utflnx.who.knows.backend.model.participant

import java.util.*

data class Response(
    val participantId: String,
    val roomId: String,
    val userId: String,
    val currentPage: String,
    val timeLeft: Int,
    val expired: Boolean,
    val createdAt: Date,
    val updatedAt: Date?
)