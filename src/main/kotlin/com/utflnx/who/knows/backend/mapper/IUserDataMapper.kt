package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.User
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.LoginRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest

interface IUserDataMapper {
    fun toUser(createRequest: CreateRequest): User
    fun toUser(current: User, updateRequest: UpdateRequest): User
    fun toResponse(user: User): Response
    fun validate(any: Any)
}