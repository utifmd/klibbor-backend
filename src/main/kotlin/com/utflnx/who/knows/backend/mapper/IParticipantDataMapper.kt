package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.Participant
import com.utflnx.who.knows.backend.model.participant.CreateRequest
import com.utflnx.who.knows.backend.model.participant.Response
import com.utflnx.who.knows.backend.model.participant.UpdateRequest

interface IParticipantDataMapper {
    fun toParticipant(createRequest: CreateRequest): Participant
    fun toParticipant(current: Participant, updateRequest: UpdateRequest): Participant
    fun toResponse(participant: Participant): Response
    fun validate(any: Any)
}