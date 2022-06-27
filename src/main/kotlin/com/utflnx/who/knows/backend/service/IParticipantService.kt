package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.participant.CreateRequest
import com.utflnx.who.knows.backend.model.participant.Response
import com.utflnx.who.knows.backend.model.participant.UpdateRequest

interface IParticipantService {
    fun create(createRequest: CreateRequest): Response
    fun read(id: String): Response
    fun read(userId: String, roomId: String): Response
    fun update(id: String, updateRequest: UpdateRequest): Response
    fun delete(id: String)
    fun list(listRequest: ListRequest): List<Response>
}