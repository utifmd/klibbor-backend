package com.utflnx.who.knows.backend.model.room

import com.utflnx.who.knows.backend.entity.User
import java.util.*

data class Response(
    val roomId: String,
    val userId: String,
    val minute: Int,
    val title: String,
    val desc: String,
    val expired: Boolean,
    val createdAt: Date,
    val updatedAt: Date?
//    ,
//    val user: User?
)