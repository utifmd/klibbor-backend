package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.Room
import com.utflnx.who.knows.backend.entity.User
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.LoginRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest

interface IUserDataMapper {
    fun toUser(createRequest: CreateRequest): User
    fun toUser(current: User, updateRequest: UpdateRequest): User
    fun toCompleteResponse(user: User): Response.Complete
    fun toCensoredResponse(user: User): Response.Censored
    fun toCensoredResponse(room: Room): com.utflnx.who.knows.backend.model.room.Response.Censored
    fun validate(any: Any)
}