package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.model.room.CreateRequest
import com.utflnx.who.knows.backend.model.room.Response
import com.utflnx.who.knows.backend.model.room.UpdateRequest

interface IRoomService {
    fun create(createRequest: CreateRequest): Response
    fun read(readRequest: String): Response
    fun update(id: String, updateRequest: UpdateRequest): Response
}