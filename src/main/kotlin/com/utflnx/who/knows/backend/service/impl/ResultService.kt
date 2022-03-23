package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IResultDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.result.CreateRequest
import com.utflnx.who.knows.backend.model.result.Response
import com.utflnx.who.knows.backend.model.result.UpdateRequest
import com.utflnx.who.knows.backend.repository.IResultRepository
import com.utflnx.who.knows.backend.repository.IRoomRepository
import com.utflnx.who.knows.backend.repository.IUserRepository
import com.utflnx.who.knows.backend.service.IResultService
import com.utflnx.who.knows.backend.validation.DataExistException
import com.utflnx.who.knows.backend.validation.DataNotFoundException
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ResultService(
    val reposResult: IResultRepository,
    val reposRoom: IRoomRepository,
    val reposUser: IUserRepository,
    val mapper: IResultDataMapper): IResultService {

    override fun create(createRequest: CreateRequest): Response {
        val result = mapper.toResult(createRequest)

        if (reposResult.existsById(result.resultId))
            throw DataExistException()

        reposRoom.findByIdOrNull(result.roomId) ?:
            throw DataNotFoundException("roomId")

        reposUser.findByIdOrNull(result.userId) ?:
            throw DataNotFoundException("userId")

        reposResult.save(result)

        return mapper.toResponse(result)
    }

    override fun read(resultId: String): Response {
        val result = reposResult.findByIdOrNull(resultId) ?: throw NotFoundException()

        return mapper.toResponse(result)
    }

    override fun read(roomId: String, userId: String): Response {
        reposRoom.findByIdOrNull(roomId) ?: throw DataNotFoundException("roomId")
        reposUser.findByIdOrNull(userId) ?: throw DataNotFoundException("userId")

        val result = reposResult.findByRoomIdAndUserIdOrNull(roomId, userId) ?: throw NotFoundException()

        return mapper.toResponse(result)
    }

    override fun update(resultId: String, updateRequest: UpdateRequest): Response {
        val current = reposResult.findByIdOrNull(resultId) ?: throw NotFoundException()
        val updatedResult = mapper.toResult(current, updateRequest)

        reposResult.save(updatedResult)

        return mapper.toResponse(updatedResult)
    }

    override fun delete(resultId: String) {
        val result = reposResult.findByIdOrNull(resultId) ?: throw NotFoundException()

        reposResult.delete(result)
    }

    override fun delete(roomId: String, userId: String) {
        val result = reposResult.findByRoomIdAndUserIdOrNull(roomId, userId) ?: throw NotFoundException()

        reposResult.delete(result)
    }

    override fun list(listRequest: ListRequest): List<Response> {
        mapper.validate(listRequest)

        val pagedResult = reposResult.findAll(PageRequest.of(listRequest.page, listRequest.size))
        val results = pagedResult.get().collect(Collectors.toList())

        return results.map(mapper::toResponse)
            .sortedByDescending { it.createdAt }
    }
}