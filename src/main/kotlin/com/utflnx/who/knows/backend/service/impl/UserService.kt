package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IUserDataMapper
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.user.LoginRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest
import com.utflnx.who.knows.backend.repository.IUserRepository
import com.utflnx.who.knows.backend.service.IUserService
import com.utflnx.who.knows.backend.validation.InvalidEmailException
import com.utflnx.who.knows.backend.validation.InvalidPasswordException
import com.utflnx.who.knows.backend.validation.NotFoundException
import com.utflnx.who.knows.backend.validation.DataExistException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UserService(
    val repository: IUserRepository,
    val mapper: IUserDataMapper): IUserService {

    override fun create(createRequest: CreateRequest): Response.Complete {
        val user = mapper.toUser(createRequest)

        if (repository.existsById(user.userId))
            throw DataExistException()

        if (repository.findByEmailOrNull(user.email) != null)
            throw DataExistException()

        user.apply { createdAt = Date() }

        repository.save(user)

        return mapper.toCompleteResponse(user)
    }

    override fun read(readRequest: String): Response.Complete {
        val user = repository.findByIdOrNull(readRequest) ?: throw NotFoundException()

        return mapper.toCompleteResponse(user)
    }

    override fun update(id: String, updateRequest: UpdateRequest): Response.Complete {
        val user = repository.findByIdOrNull(id) ?: throw NotFoundException()
        val updatedUser = mapper.toUser(user, updateRequest)

        repository.save(updatedUser)

        return mapper.toCompleteResponse(updatedUser)
    }

    override fun delete(deleteRequest: String) {
        if(repository.findByIdOrNull(deleteRequest) != null)
            repository.deleteById(deleteRequest)

        else throw NotFoundException()
    }

    override fun list(listRequest: ListRequest): List<Response.Complete> {
        mapper.validate(listRequest)
        val page = repository.findAll(
            PageRequest.of(listRequest.page, listRequest.size)).map(mapper::toCompleteResponse)

        return page.get().collect(Collectors.toList())
    }

    override fun signIn(loginRequest: LoginRequest): Response.Complete {
        mapper.validate(loginRequest)

        val current = repository.findByEmailOrPhoneOrUnameOrNull(loginRequest.payload)
            ?: throw InvalidEmailException()

        if (current.password != loginRequest.password)
            throw InvalidPasswordException()

        return mapper.toCompleteResponse(current)
    }

    override fun activelyParticipants(listRequest: ListRequest): List<Response.Censored> {
        mapper.validate(listRequest)
        val paged = repository.findActivelyParticipants(PageRequest.of(listRequest.page, listRequest.size))

        return paged.stream().collect(Collectors.toList())
            .map(mapper::toCensoredResponse)
    }
}
// @Autowired // lateinit var mapper: IUserDataMapper
// @Query("SELECT * FROM USER INNER JOIN ...") // override fun readExplore(): Response { }