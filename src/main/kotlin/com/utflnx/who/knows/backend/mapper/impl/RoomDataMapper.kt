package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.Room
import com.utflnx.who.knows.backend.mapper.IRoomDataMapper
import com.utflnx.who.knows.backend.mapper.IUserDataMapper
import com.utflnx.who.knows.backend.model.room.CreateRequest
import com.utflnx.who.knows.backend.model.room.Response
import com.utflnx.who.knows.backend.model.room.UpdateRequest
import com.utflnx.who.knows.backend.validation.impl.DataValidator
import org.springframework.stereotype.Component
import java.util.*

@Component
class RoomDataMapper(
    val validator: DataValidator, val userMapper: IUserDataMapper): IRoomDataMapper {
    override fun toRoom(createRequest: CreateRequest): Room {
        validate(createRequest)

        return Room(
            createRequest.roomId ?: "",
            createRequest.userId ?: "",
            createRequest.minute ?: 0,
            createRequest.title ?: "",
            createRequest.description ?: "",
            createRequest.expired ?: true,
            Date(),
            null,
            null,
            questions = emptyList(),
            participants = emptyList()
        )
    }

    override fun toRoom(current: Room, updateRequest: UpdateRequest): Room {
        validate(updateRequest)

        current.apply {
            minute = updateRequest.minute ?: 0
            title = updateRequest.title ?: ""
            description = updateRequest.description ?: ""
            expired = updateRequest.expired ?: false
            updatedAt = Date()
        }

        return current
    }

    override fun toCompleteResponse(room: Room): Response.Complete {
        return Response.Complete(
            room.roomId,
            room.userId,
            room.minute,
            room.title,
            room.description,
            room.expired,
            room.createdAt,
            room.updatedAt,
            room.user?.let(userMapper::toCensoredResponse),
            room.questions,
            room.participants
        )
    }

    override fun toCensoredResponse(room: Room): Response.Censored {
        return Response.Censored(
            roomId = room.roomId,
            userId = room.userId,
            minute = room.minute,
            title = room.title,
            description = room.description,
            expired = room.expired,
            usernameOwner = room.user?.username ?: "unknown",
            fullNameOwner = room.user?.fullName ?: "unknown",
            questionSize = room.questions.size,
            participantSize = room.participants.size,
        )
    }

    override fun validate(any: Any) {
        validator.validate(any)
    }
}