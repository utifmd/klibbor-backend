package com.utflnx.who.knows.backend.model.result

import com.utflnx.who.knows.backend.entity.User
import java.util.*

data class Response(
    val resultId: String, //val participantId: String,
    val roomId: String,
    val userId: String,
    val correctQuiz: List<String>,
    val wrongQuiz: List<String>,
    val score: Int,
    val createdAt: Date,
    val updatedAt: Date?,
    val user: User?
)