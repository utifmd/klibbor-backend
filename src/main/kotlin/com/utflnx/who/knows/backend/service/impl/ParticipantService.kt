package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IParticipantDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.participant.CreateRequest
import com.utflnx.who.knows.backend.model.participant.Response
import com.utflnx.who.knows.backend.model.participant.UpdateRequest
import com.utflnx.who.knows.backend.repository.IParticipantRepository
import com.utflnx.who.knows.backend.service.IParticipantService
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ParticipantService(
    val repository: IParticipantRepository,
    val mapper: IParticipantDataMapper): IParticipantService {

    override fun create(createRequest: CreateRequest): Response {
        val participant = mapper.toParticipant(createRequest)

        repository.save(participant)
        return mapper.toResponse(participant)
    }

    override fun read(id: String): Response {
        val participant = repository.findByIdOrNull(id) ?: throw NotFoundException()

        return mapper.toResponse(participant)
    }

    override fun update(id: String, updateRequest: UpdateRequest): Response {
        val current = repository.findByIdOrNull(id) ?: throw NotFoundException()
        val updatedParticipant = mapper.toParticipant(current, updateRequest)

        repository.save(updatedParticipant)

        return mapper.toResponse(updatedParticipant)
    }

    override fun delete(id: String) {
        val participant = repository.findByIdOrNull(id) ?: throw NotFoundException()

        repository.delete(participant)
    }

    override fun list(listRequest: ListRequest): List<Response> {
        mapper.validate(listRequest)

        val pagedParticipant = repository.findAll(PageRequest.of(listRequest.page, listRequest.size))
        val participants = pagedParticipant.get().collect(Collectors.toList())

        return participants.map { mapper.toResponse(it) }
    }
}