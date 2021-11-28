package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IRoomDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.room.CreateRequest
import com.utflnx.who.knows.backend.model.room.Response
import com.utflnx.who.knows.backend.model.room.UpdateRequest
import com.utflnx.who.knows.backend.repository.IRoomRepository
import com.utflnx.who.knows.backend.service.IRoomService
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class RoomService(
    val repository: IRoomRepository,
    val mapper: IRoomDataMapper): IRoomService {

    override fun create(createRequest: CreateRequest): Response {
        val room = mapper.toRoom(createRequest)

        room.apply { createdAt = Date() }

        repository.save(room)
        return mapper.toResponse(room)
    }

    override fun read(readRequest: String): Response {
        val room = repository.findByIdOrNull(readRequest) ?: throw NotFoundException()

        return mapper.toResponse(room)
    }

    override fun update(id: String, updateRequest: UpdateRequest): Response {
        val room = repository.findByIdOrNull(id) ?: throw NotFoundException()
        val updatedRoom = mapper.toRoom(room, updateRequest)

        repository.save(updatedRoom)

        return mapper.toResponse(updatedRoom)
    }

    override fun delete(id: String) {
        val room = repository.findByIdOrNull(id) ?: throw NotFoundException()

        repository.delete(room)
    }

    override fun list(listRequest: ListRequest): List<Response> {
        val pagedRoom = repository.findAll(PageRequest.of(listRequest.page, listRequest.size))

        val rooms = pagedRoom.get().collect(Collectors.toList())

        return rooms.map {
            mapper.toResponse(it)
        }
    }
}