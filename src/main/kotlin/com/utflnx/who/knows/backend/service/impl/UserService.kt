package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IUserDataMapper
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.ListRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest
import com.utflnx.who.knows.backend.repository.IUserRepository
import com.utflnx.who.knows.backend.service.IUserService
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UserService(
    val repository: IUserRepository, // @Autowired // lateinit var mapper: IUserDataMapper
    val mapper: IUserDataMapper): IUserService { // @Query("SELECT * FROM USER INNER JOIN ...") // override fun readExplore(): Response { }

    override fun create(createRequest: CreateRequest): Response {
        val user = mapper.toUser(createRequest)

        user.apply { createdAt = Date() }

        repository.save(user)
        return mapper.toResponse(user)
    }

    override fun read(readRequest: String): Response {
        val user = repository.findByIdOrNull(readRequest) ?: throw NotFoundException()

        return mapper.toResponse(user)
    }

    override fun update(id: String, updateRequest: UpdateRequest): Response {
        val user = repository.findByIdOrNull(id) ?: throw NotFoundException()
        val updatedUser = mapper.toUser(user, updateRequest)

        repository.save(updatedUser)

        return mapper.toResponse(updatedUser)
    }

    override fun delete(deleteRequest: String) {
        if(repository.findByIdOrNull(deleteRequest) != null)
            repository.deleteById(deleteRequest)

        else throw NotFoundException()
    }

    override fun list(listRequest: ListRequest): List<Response> {
        val page = repository.findAll(PageRequest.of(listRequest.page, listRequest.size))
        val users = page.get().collect(Collectors.toList())

        return users.map { mapper.toResponse(it) }
    }
}