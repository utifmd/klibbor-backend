package com.utflnx.who.knows.backend.model.room

import com.utflnx.who.knows.backend.entity.Participant
import com.utflnx.who.knows.backend.entity.Quiz
import java.util.*

sealed class Response {
    data class Censored(
        val roomId: String,
        val userId: String,
        val minute: Int,
        val title: String,
        val description: String,
        val expired: Boolean,
        val usernameOwner: String,
        val fullNameOwner: String,
        val questionSize: Int,
        val participantSize: Int): Response()

    data class Complete(
        val roomId: String,
        val userId: String,
        val minute: Int,
        val title: String,
        val description: String,
        val expired: Boolean,
        val createdAt: Date,
        val updatedAt: Date?,
        val user: com.utflnx.who.knows.backend.model.user.Response.Censored?,
        val questions: List<Quiz>,
        val participants: List<Participant>
    ): Response()
}