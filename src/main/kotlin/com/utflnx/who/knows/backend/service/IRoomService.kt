package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.room.CreateRequest
import com.utflnx.who.knows.backend.model.room.Response
import com.utflnx.who.knows.backend.model.room.UpdateRequest

interface IRoomService {
    fun create(createRequest: CreateRequest): Response.Complete
    fun read(readRequest: String): Response.Complete
    fun update(id: String, updateRequest: UpdateRequest): Response.Complete
    fun delete(id: String)
    fun list(userId: String, listRequest: ListRequest): List<Response.Complete>
    fun list(listRequest: ListRequest): List<Response.Censored>
    fun search(query: String, listRequest: ListRequest): List<Response.Censored>
}