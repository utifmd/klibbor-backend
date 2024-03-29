package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IRoomDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.room.CreateRequest
import com.utflnx.who.knows.backend.model.room.Response
import com.utflnx.who.knows.backend.model.room.UpdateRequest
import com.utflnx.who.knows.backend.repository.IRoomRepository
import com.utflnx.who.knows.backend.repository.IUserRepository
import com.utflnx.who.knows.backend.service.IRoomService
import com.utflnx.who.knows.backend.validation.DataExistException
import com.utflnx.who.knows.backend.validation.DataNotFoundException
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class RoomService(
    val reposRoom: IRoomRepository,
    val reposUser: IUserRepository,
    val mapper: IRoomDataMapper): IRoomService {

    override fun create(createRequest: CreateRequest): Response.Complete {
        val room = mapper.toRoom(createRequest)

        if (reposRoom.existsById(room.roomId))
            throw DataExistException()

        reposUser.findByIdOrNull(room.userId) ?:
            throw DataNotFoundException("userId")

        room.apply { createdAt = Date() }

        reposRoom.save(room)

        return mapper.toCompleteResponse(room)
    }

    override fun read(readRequest: String): Response.Complete {
        val room = reposRoom.findByIdOrNull(readRequest) ?: throw NotFoundException()

        return mapper.toCompleteResponse(room)
    }

    override fun update(id: String, updateRequest: UpdateRequest): Response.Complete {
        val room = reposRoom.findByIdOrNull(id) ?: throw NotFoundException()
        val updatedRoom = mapper.toRoom(room, updateRequest)

        reposRoom.save(updatedRoom)

        return mapper.toCompleteResponse(updatedRoom)
    }

    override fun delete(id: String) {
        val room = reposRoom.findByIdOrNull(id) ?: throw NotFoundException()

        reposRoom.delete(room)
    }

    override fun list(userId: String, listRequest: ListRequest): List<Response.Complete> {
        mapper.validate(userId)
            val rooms = reposRoom.findAllByUserId(userId, PageRequest.of(listRequest.page, listRequest.size))

        return rooms.map(mapper::toCompleteResponse)
            .sortedByDescending { it.createdAt }
            .sortedBy { it.expired }
    }

    override fun list(listRequest: ListRequest): List<Response.Censored> {
        mapper.validate(listRequest)

        return reposRoom
            .findAll(PageRequest.of(listRequest.page, listRequest.size)).map(mapper::toCensoredResponse)
            .filter{ !it.private }
            .sortedByDescending { it.participantSize }
            //.sortedBy { it.expired }

        //val rooms = pagedRoom.stream().collect(Collectors.toList()) return rooms
    }

    override fun search(query: String, listRequest: ListRequest): List<Response.Censored> {
        mapper.validate(query)
        mapper.validate(listRequest)

        val paged = reposRoom.searchRoomByTitleAndDesc(query, PageRequest.of(listRequest.page, listRequest.size))
        return paged.stream().collect(Collectors.toList())
            .map(mapper::toCensoredResponse)
            .onEach {
                println("tokenSize "+ it.participantTokens.size)
            }
    }
}