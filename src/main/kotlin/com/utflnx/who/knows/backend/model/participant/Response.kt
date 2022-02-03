package com.utflnx.who.knows.backend.model.participant

import com.utflnx.who.knows.backend.entity.Result
import com.utflnx.who.knows.backend.entity.User
import java.util.*

data class Response(
    val participantId: String,
    val roomId: String,
    val userId: String,
    val currentPage: String,
    val timeLeft: Int,
    val expired: Boolean,
    val createdAt: Date,
    val updatedAt: Date?,
    val user: User?
    //val result: List<Result>
)