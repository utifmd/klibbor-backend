package com.utflnx.who.knows.backend.model.user

import com.utflnx.who.knows.backend.entity.Notification
import com.utflnx.who.knows.backend.entity.Participant
import com.utflnx.who.knows.backend.entity.Room
import java.util.*

sealed class Response {
    data class Censored(
        val userId: String,
        val fullName: String,
        val username: String,
        val profileUrl: String): Response()

    data class Complete(
        val userId: String?,
        val fullName: String?,
        val email: String?,
        val phone: String?,
        val username: String,
        val password: String?,
        val profileUrl: String,
        val createdAt: Date?,
        val updatedAt: Date?,
        val participants: List<Participant>?,
        val rooms: List<Room>?,
        val notifications: List<Notification>?): Response()
}