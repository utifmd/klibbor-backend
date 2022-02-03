package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IParticipantDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.participant.CreateRequest
import com.utflnx.who.knows.backend.model.participant.Response
import com.utflnx.who.knows.backend.model.participant.UpdateRequest
import com.utflnx.who.knows.backend.repository.IParticipantRepository
import com.utflnx.who.knows.backend.repository.IRoomRepository
import com.utflnx.who.knows.backend.repository.IUserRepository
import com.utflnx.who.knows.backend.service.IParticipantService
import com.utflnx.who.knows.backend.validation.DataExistException
import com.utflnx.who.knows.backend.validation.DataNotFoundException
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ParticipantService(
    val reposParticipant: IParticipantRepository,
    val reposRoom: IRoomRepository,
    val reposUser: IUserRepository,
    val mapper: IParticipantDataMapper): IParticipantService {

    override fun create(createRequest: CreateRequest): Response {
        val participant = mapper.toParticipant(createRequest)

        if (reposParticipant.existsById(participant.participantId))
            throw DataExistException()

        reposRoom.findByIdOrNull(participant.roomId) ?:
            throw DataNotFoundException("roomId")

        reposUser.findByIdOrNull(participant.userId) ?:
            throw DataNotFoundException("userId")

        reposParticipant.save(participant)

        return mapper.toResponse(participant)
    }

    override fun read(id: String): Response {
        val participant = reposParticipant.findByIdOrNull(id) ?: throw NotFoundException()

        return mapper.toResponse(participant)
    }

    override fun update(id: String, updateRequest: UpdateRequest): Response {
        val current = reposParticipant.findByIdOrNull(id) ?: throw NotFoundException()
        val updatedParticipant = mapper.toParticipant(current, updateRequest)

        reposParticipant.save(updatedParticipant)

        return mapper.toResponse(updatedParticipant)
    }

    override fun delete(id: String) {
        val participant = reposParticipant.findByIdOrNull(id) ?: throw NotFoundException()

        reposParticipant.delete(participant)
    }

    override fun list(listRequest: ListRequest): List<Response> {
        mapper.validate(listRequest)

        val pagedParticipant = reposParticipant.findAll(PageRequest.of(listRequest.page, listRequest.size))
        val participants = pagedParticipant.get().collect(Collectors.toList())

        return participants.map { mapper.toResponse(it) }
    }
}