package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IUserDataMapper
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.repository.IUserRepository
import com.utflnx.who.knows.backend.service.IUserService
import org.springframework.stereotype.Service

@Service
class UserService(
    val repository: IUserRepository,
    val mapper: IUserDataMapper): IUserService { // @Autowired // lateinit var mapper: IUserDataMapper
    override fun create(createRequest: CreateRequest): Response {
        val user = mapper.toUser(createRequest)

        repository.save(user)
        return mapper.toResponse(user)
    }

    // @Query("SELECT * FROM USER INNER JOIN ...") // override fun readExplore(): Response { }
}