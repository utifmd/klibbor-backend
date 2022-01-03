package com.utflnx.who.knows.backend.model.quiz

import java.util.*

data class Response(
    val id: String,
    val roomId: String,
    val images: List<String>,
    val question: String,
    val options: List<String>,
    val answer: String,
    val createdBy: String,
    val createdAt: Date,
    val updatedAt: Date?
)