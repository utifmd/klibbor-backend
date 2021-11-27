package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.Room
import com.utflnx.who.knows.backend.mapper.IRoomDataMapper
import com.utflnx.who.knows.backend.model.room.CreateRequest
import com.utflnx.who.knows.backend.model.room.Response
import com.utflnx.who.knows.backend.model.room.UpdateRequest
import com.utflnx.who.knows.backend.validation.impl.DataValidator
import org.springframework.stereotype.Component
import java.util.*

@Component
class RoomDataMapper(val validator: DataValidator): IRoomDataMapper {
    override fun toRoom(createRequest: CreateRequest): Room {
        validator.validate(createRequest)

        return Room(
            createRequest.roomId ?: "",
            createRequest.userId ?: "",
            createRequest.minute ?: 0,
            createRequest.title ?: "",
            createRequest.description ?: "",
            createRequest.expired ?: true,
            Date(),
            null
        )
    }

    override fun toRoom(current: Room, updateRequest: UpdateRequest): Room {
        validator.validate(updateRequest)

        current.apply {
            minute = updateRequest.minute ?: 0
            title = updateRequest.title ?: ""
            description = updateRequest.description ?: ""
            expired = updateRequest.expired ?: false
            updatedAt = Date()
        }

        return current
    }

    override fun toResponse(room: Room): Response {
        return Response(
            room.id,
            room.userId,
            room.minute,
            room.title,
            room.description,
            room.expired,
            room.createdAt,
            room.updatedAt ?: Date()
        )
    }
}