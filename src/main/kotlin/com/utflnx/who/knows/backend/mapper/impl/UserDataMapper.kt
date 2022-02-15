package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.User
import com.utflnx.who.knows.backend.mapper.IUserDataMapper
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest
import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserDataMapper(val validator: IDataValidator): IUserDataMapper {

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
            updatedAt = null, //, rooms = emptyList()
            participants = emptyList()
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
            updatedAt = Date()
        }

        return current
    }

    override fun toResponse(user: User): Response{
        return Response(
            userId = user.userId,
            fullName = user.fullName,
            email = user.email,
            phone = user.phone,
            username = user.username,
            password = user.password,
            profileUrl = user.profileUrl,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt,
            participants = user.participants
        )
    }

    override fun validate(any: Any) {
        validator.validate(any)
    }
}