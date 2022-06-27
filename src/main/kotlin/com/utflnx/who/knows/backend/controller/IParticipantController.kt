package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.participant.CreateRequest
import com.utflnx.who.knows.backend.model.participant.Response
import com.utflnx.who.knows.backend.model.participant.UpdateRequest

interface IParticipantController {
    fun createParticipant(createRequest: CreateRequest): WebResponse<Response>
    fun readParticipant(id: String): WebResponse<Response>
    fun readParticipant(userId: String, roomId: String): WebResponse<Response>
    fun updateParticipant(id: String, updateRequest: UpdateRequest): WebResponse<Response>
    fun deleteParticipant(id: String): WebResponse<String>
    fun listParticipant(page: Int, size: Int): WebResponse<List<Response>>
}