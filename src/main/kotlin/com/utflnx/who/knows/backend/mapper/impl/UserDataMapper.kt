package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.User
import com.utflnx.who.knows.backend.mapper.IUserDataMapper
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.LoginRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest
import com.utflnx.who.knows.backend.validation.impl.DataValidator
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserDataMapper(val dataValidator: DataValidator): IUserDataMapper {

    override fun toUser(createRequest: CreateRequest): User {
        dataValidator.validate(createRequest)

        return User(
            id = createRequest.userId!!,
            fullName = createRequest.fullName!!,
            email = createRequest.email!!,
            phone = createRequest.phone!!,
            username = createRequest.username!!,
            password = createRequest.password!!,
            createdAt = Date(),
            updatedAt = null,
            rooms = emptyList()
        )
    }

    override fun toUser(current: User, updateRequest: UpdateRequest): User {
        dataValidator.validate(updateRequest)

        current.apply {
            fullName = updateRequest.fullName!!
            email = updateRequest.email!!
            phone = updateRequest.phone!!
            username = updateRequest.username!!
            password = updateRequest.password!!
            updatedAt = Date()
        }

        return current
    }

    override fun toResponse(user: User): Response{
        return Response(
            userId = user.id,
            fullName = user.fullName,
            email = user.email,
            phone = user.phone,
            username = user.username,
            password = user.password,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt,
            room = user.rooms
        )
    }

    override fun validate(model: Any) {
        dataValidator.validate(model)
    }
}