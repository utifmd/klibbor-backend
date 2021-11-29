package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IResultDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.result.CreateRequest
import com.utflnx.who.knows.backend.model.result.Response
import com.utflnx.who.knows.backend.model.result.UpdateRequest
import com.utflnx.who.knows.backend.repository.IResultRepository
import com.utflnx.who.knows.backend.service.IResultService
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ResultService(
    val repository: IResultRepository, val mapper: IResultDataMapper): IResultService {
    override fun create(createRequest: CreateRequest): Response {
        val result = mapper.toResult(createRequest)

        repository.save(result)
        return mapper.toResponse(result)
    }

    override fun read(resultId: String): Response {
        val result = repository.findByIdOrNull(resultId) ?: throw NotFoundException()

        return mapper.toResponse(result)
    }

    override fun update(resultId: String, updateRequest: UpdateRequest): Response {
        val current = repository.findByIdOrNull(resultId) ?: throw NotFoundException()
        val updatedResult = mapper.toResult(current, updateRequest)

        repository.save(updatedResult)

        return mapper.toResponse(updatedResult)
    }

    override fun delete(resultId: String) {
        val result = repository.findByIdOrNull(resultId) ?: throw NotFoundException()

        repository.delete(result)
    }

    override fun list(listRequest: ListRequest): List<Response> {
        mapper.validate(listRequest)

        val pagedResult = repository.findAll(PageRequest.of(listRequest.page, listRequest.size))
        val results = pagedResult.get().collect(Collectors.toList())

        return results.map { mapper.toResponse(it) }
    }
}