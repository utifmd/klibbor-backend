package com.utflnx.who.knows.backend.model.quiz

import com.utflnx.who.knows.backend.entity.User
import java.util.*

data class Response(
    val quizId: String,
    val roomId: String,
    val images: List<String>,
    val question: String,
    val options: List<String>,
    val answer: String,
    val createdBy: String,
    val createdAt: Date,
    val updatedAt: Date?,
    val user: User?
)