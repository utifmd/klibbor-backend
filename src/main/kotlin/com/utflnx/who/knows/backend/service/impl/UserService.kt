package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.entity.User
import com.utflnx.who.knows.backend.mapper.IUserDataMapper
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.user.LoginRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest
import com.utflnx.who.knows.backend.repository.IUserRepository
import com.utflnx.who.knows.backend.service.IUserService
import com.utflnx.who.knows.backend.validation.*
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

        if (repository.findByUsernameOrNull(user.username) != null) {
            user.username = user.username.plus(Date().time)
        }
        user.createdAt = Date()

        repository.save(user)

        return mapper.toCompleteResponse(user)
    }

    override fun read(userId: String): Response.Complete {
        val user = repository.findByIdOrNull(userId) ?: throw NotFoundException()

        return mapper.toCompleteResponse(user)
    }
    override fun update(userId: String, updateRequest: UpdateRequest): Response.Complete {
        val currentUser = repository.findByIdOrNull(userId) ?: throw NotFoundException()
        val updatedUser = mapper.toUser(currentUser, updateRequest)

        repository.save(updatedUser)
        return mapper.toCompleteResponse(updatedUser)
    }
    override fun count(username: String): Int = repository.countUserNameUsage(username)

    override fun update(userId: String, user: User): Response.Complete {
        repository.findByIdOrNull(userId) ?: throw NotFoundException()

        repository.save(user)
        return mapper.toCompleteResponse(user)
    }
    override fun delete(userId: String) {
        if(repository.findByIdOrNull(userId) != null)
            repository.deleteById(userId)

        else throw NotFoundException()
    }
    override fun list(listRequest: ListRequest): List<Response.Complete> {
        mapper.validate(listRequest)
        val page = repository
            .findAll(PageRequest.of(listRequest.page, listRequest.size))
            .map(mapper::toCompleteResponse)

        return page.get().collect(Collectors.toList())
    }
    override fun signIn(loginRequest: LoginRequest): Response.Complete {
        mapper.validate(loginRequest)

        val current = repository.findByEmailOrPhoneOrUnameOrNull(loginRequest.payload)
            ?: throw InvalidEmailException()

        if (current.password != loginRequest.password)
            throw InvalidPasswordException()

        val tokens = current.tokens.toMutableList()
        loginRequest.token?.let{ tokens.add(0, it) }

        val freshTokens = tokens.distinct()
            .filterIndexed { i, _-> i in 0..2 }

        if (!loginRequest.token.isNullOrBlank() && freshTokens.isNotEmpty())
            update(current.userId, current.copy(tokens = freshTokens))

        return mapper.toCompleteResponse(current)
    }
    override fun search(query: String, listRequest: ListRequest): List<Response.Censored> {
        mapper.validate(query)
        mapper.validate(listRequest)

        val pagedResult = repository.searchUserByUsernameOrFullName(query.lowercase(), PageRequest.of(listRequest.page, listRequest.size))
        return pagedResult.stream().collect(Collectors.toList())
            .map(mapper::toCensoredResponse)
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