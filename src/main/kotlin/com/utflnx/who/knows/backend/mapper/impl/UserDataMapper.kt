package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.Room
import com.utflnx.who.knows.backend.entity.User
import com.utflnx.who.knows.backend.mapper.IUserDataMapper
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest
import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserDataMapper(
    val validator: IDataValidator): IUserDataMapper {

    override fun toUser(createRequest: CreateRequest): User {
        validate(createRequest)

        return User(
            userId = createRequest.userId ?: "",
            fullName = createRequest.fullName ?: "",
            email = createRequest.email ?: "",
            phone = createRequest.phone ?: "",
            username = createRequest.username ?: "",
            password = createRequest.password ?: "",
            profileUrl = createRequest.profileUrl ?: "",
            createdAt = Date(),
            updatedAt = null,
            tokens = createRequest.tokens ?: emptyList(),
            participants = emptyList(),
            rooms = emptyList(),
            notifications = emptyList()
        )
    }

    override fun toUser(current: User, updateRequest: UpdateRequest): User {
        validate(updateRequest)

        current.apply {
            fullName = updateRequest.fullName ?: ""
            email = updateRequest.email ?: ""
            phone = updateRequest.phone ?: ""
            username = updateRequest.username ?: ""
            password = updateRequest.password ?: ""
            profileUrl = updateRequest.profileUrl ?: ""
            tokens = updateRequest.tokens ?: emptyList()
            updatedAt = Date()
        }

        return current
    }

    override fun toCompleteResponse(user: User): Response.Complete{
        return Response.Complete(
            userId = user.userId,
            fullName = user.fullName,
            email = user.email,
            phone = user.phone,
            username = user.username,
            password = user.password,
            profileUrl = user.profileUrl,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt,
            participants = user.participants,
            rooms = user.rooms.map(::toCensoredResponse),
            notifications = user.notifications,
            tokens = user.tokens
        )
    }

    override fun toCensoredResponse(user: User): Response.Censored {
        return Response.Censored(
            userId = user.userId,
            fullName = user.fullName,
            username = user.username,
            profileUrl = user.profileUrl,
            tokens = user.tokens
        )
    }

    override fun toCensoredResponse(room: Room): com.utflnx.who.knows.backend.model.room.Response.Censored {
        return com.utflnx.who.knows.backend.model.room.Response.Censored(
            roomId = room.roomId,
            userId = room.userId,
            minute = room.minute,
            title = room.title,
            description = room.description,
            token = room.token ?: "",
            expired = room.expired,
            private = room.private ?: false,
            user = room.user?.let(::toCensoredResponse),
            questionSize = room.questions.size,
            participantSize = room.participants.size,
            participantIds = room.participants.map { it.userId },
            participantTokens = room.participants.mapNotNull{ it.user?.tokens?.getOrNull(0) },
            impressions = room.impressions
        )
    }

    override fun validate(any: Any) {
        validator.validate(any)
    }
}