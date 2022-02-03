package com.utflnx.who.knows.backend.model.notification

import com.utflnx.who.knows.backend.entity.User
import java.util.*

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
data class Response(
    val notificationId: String,
    val userId: String,
    val roomId: String,
    val event: String,
    val seen: Boolean,
    val recipientId: String,
    val createdAt: Date,
    val updatedAt: Date?,
    val sender: User?
)
