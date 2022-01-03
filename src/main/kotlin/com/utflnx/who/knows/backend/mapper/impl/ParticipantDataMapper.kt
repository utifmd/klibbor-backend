package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.Participant
import com.utflnx.who.knows.backend.mapper.IParticipantDataMapper
import com.utflnx.who.knows.backend.model.participant.CreateRequest
import com.utflnx.who.knows.backend.model.participant.Response
import com.utflnx.who.knows.backend.model.participant.UpdateRequest
import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component
import java.util.*

@Component
class ParticipantDataMapper(val validator: IDataValidator): IParticipantDataMapper {
    override fun toParticipant(createRequest: CreateRequest): Participant {
        validate(createRequest)

        return Participant(
            createRequest.id ?: "",
            createRequest.roomId ?: "",
            createRequest.userId ?: "",
            createRequest.currentPage ?: "",
            createRequest.timeLeft ?: 0,
            createRequest.expired ?: false,
            Date(),
            updatedAt = null,
            //results = emptyList()
        )
    }

    override fun toParticipant(current: Participant, updateRequest: UpdateRequest): Participant {
        validate(updateRequest)

        current.apply {
            currentPage = updateRequest.currentPage ?: ""
            timeLeft = updateRequest.timeLeft ?: 0
            expired = updateRequest.expired ?: false
            updatedAt = Date()
        }

        return current
    }

    override fun toResponse(participant: Participant): Response {
        return Response(
            participant.id,
            participant.roomId,
            participant.userId,
            participant.currentPage,
            participant.timeLeft ?: 0,
            participant.expired,
            participant.createdAt,
            participant.updatedAt,
            //participant.results
        )
    }

    override fun validate(any: Any) {
        validator.validate(any)
    }
}