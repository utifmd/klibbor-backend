package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.User
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.Response

interface IUserDataMapper {
    fun toUser(createRequest: CreateRequest): User
    fun toResponse(user: User): Response
}