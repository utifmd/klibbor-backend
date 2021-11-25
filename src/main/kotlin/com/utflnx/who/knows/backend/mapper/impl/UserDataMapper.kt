package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.User
import com.utflnx.who.knows.backend.mapper.IUserDataMapper
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.validation.impl.DataValidator
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserDataMapper(val dataValidator: DataValidator): IUserDataMapper {
    override fun toUser(createRequest: CreateRequest): User {
        dataValidator.validate(createRequest)

        return User(
            userId = createRequest.userId!!,
            fullName = createRequest.fullName!!,
            email = createRequest.email!!,
            phone = createRequest.phone!!,
            username = createRequest.username!!,
            password = createRequest.password!!,
            createdAt = Date(),
            updatedAt = null
        )
    }
    override fun toResponse(user: User): Response{
        return Response(
            userId = user.userId,
            fullName = user.fullName,
            email = user.email,
            phone = user.phone,
            username = user.username,
            password = user.password,
            createdAt = Date(),
            updatedAt = null
        )
    }
}